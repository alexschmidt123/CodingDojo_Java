package com.coding.omikujiform;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController
{
	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String form() {
		return "form";
	}
	
	@PostMapping( "/process")
	public String process(@RequestParam(value="number") Integer number,
						  @RequestParam(value="nameOfCity") String nameOfCity,
						  @RequestParam(value="nameOfPerson") String nameOfPerson,
						  @RequestParam(value="hobby") String hobby,
						  @RequestParam(value="livingThing") String livingThing,
						  @RequestParam(value="sentence") String sentence,
						  Model model,
						  HttpSession session) {
			System.out.println(number);
			System.out.println(nameOfCity);
			System.out.println(nameOfPerson);
			System.out.println(hobby);
			System.out.println(livingThing);
			System.out.println(sentence);
			
		
			session.setAttribute("number", number);
			session.setAttribute("nameOfCity", nameOfCity);
			session.setAttribute("nameOfPerson", nameOfPerson);
			session.setAttribute("hobby", hobby);
			session.setAttribute("livingThing", livingThing);
			session.setAttribute("sentence", sentence);
	    	return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String show(Model model, HttpSession session) {
		
		return "result";
	}
};