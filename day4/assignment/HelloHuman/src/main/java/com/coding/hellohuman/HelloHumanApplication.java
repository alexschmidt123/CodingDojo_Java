package com.coding.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	@RestController
	public class RootController
	{

		@RequestMapping("/")
		public String HelloHuman()
		{
			return "<h1>Hello Human</h1>";
		}
		
		@RequestMapping("/?name=firstName&last_name=lastName")
		public String HelloSomebody( @RequestParam(value="firstName",required=false, defaultValue="Human")String name,@RequestParam(value="lastName", required=false, defaultValue="")String last_name)
		{
			return "<h1>Hello "+name+last_name+"</h1>";			
		}
	};

}
