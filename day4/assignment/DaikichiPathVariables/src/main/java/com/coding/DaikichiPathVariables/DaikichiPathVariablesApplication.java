package com.coding.DaikichiPathVariables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DaikichiPathVariablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiPathVariablesApplication.class, args);
	}
	@RequestMapping("/daikichi/travel/{place}")
    public String showLesson(@PathVariable("place") String place){
    	return "<h1>Congratulations! You will soon travel to  " + place + "<h1>";
    }
	@RequestMapping("/daikichi/lotto/{num}")
    public String lotto(@PathVariable("num") Integer num){
    	if (num%2==0) {
    		return "You will take a grand journey in the near future, but be weary of tempting offers";
    	}else {
    		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
    	}
    }
}
