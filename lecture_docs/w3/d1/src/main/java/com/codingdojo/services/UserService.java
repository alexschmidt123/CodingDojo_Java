package com.codingdojo.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.models.LoginUser;
import com.codingdojo.models.User;
import com.codingdojo.repositories.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}
	
	public static Boolean IsLoggedIn(HttpSession session)
	{
		return session.getAttribute("user_id")!=null;
	}
	
	public static String Logout(HttpSession session)
	{
		if(!IsLoggedIn(session)) return "redirect:/login";
		session.removeAttribute("user_id");
		return "redirect:/login";
	}
	
	public static String Deny()
	{
		return "user_deny";
	}

	public void Create(User user)
	{
		userRepository.save(user);
	}

	public User FindByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}

	public User Register(User user,BindingResult result)
	{
		User existing_user=userRepository.findByEmail(user.getEmail());
		int errors=0;
		if(existing_user!=null)
		{
			result.rejectValue("email","email_invalid","Email is in use.");
			errors++;
		}
		if(!user.getPassword().equals(user.getConfirm()))
		{
			result.rejectValue("password","password_mismatch","Password and Password Confirmation must match!");
			errors++;
		}
		if(errors>0) return null;
		String hashed_pw=BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(8));
		user.setPassword(hashed_pw);
		userRepository.save(user);
		return user;
	}
	
	public User Login
	(
		LoginUser form_user,
		BindingResult result,
		HttpSession session
	)
	{
		User db_user=userRepository.findByEmail(form_user.getEmail());
		int errors=0;
		if(db_user==null)
		{
			result.rejectValue("email","invalid_email","Email not found.");
			errors++;
		}
		if(db_user!=null)
		{
			Boolean match=BCrypt.checkpw(form_user.getPassword(),db_user.getPassword());
			if(!match)
			{
				result.rejectValue("password","invalid_password","Invalid Password");
				errors++;
			}
		}
		if(errors>0) return null;
		session.setAttribute("user_id",db_user.getId());
		return db_user;
	}	
}
