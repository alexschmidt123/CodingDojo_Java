package com.coding.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	
	
	
		@RequestMapping("/")
		public String HelloSomebody( @RequestParam(value="name",required=false, defaultValue="Human")String firstname,
									 @RequestParam(value="last_name", required=false, defaultValue="")String lastname,
									 @RequestParam(value="times", required=false, defaultValue="1")Integer repeat_times)
		{
			return "<h1>Hello "+firstname+" "+lastname+"</h1>";
			
			for (int i; i<repeat_times;i++) {
				
			};
		}
	

}
