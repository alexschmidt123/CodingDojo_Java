package com.coding.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController
{

	@RequestMapping("/users")
	public String index()
	{
		return "<h1>Welcome to users home page! What up world!</h1>";
	}
	
	@RequestMapping("/users/{id}")
	public String find_user( @PathVariable("id") Integer user_id )
	{
		if(user_id%2==0)
		{
			return "<h1>Hello even number: "+user_id+"</h1>";			
		}
		else
		{
			return "<h1>Hello odd number: "+user_id+"</h1>";			
		}
	}
};