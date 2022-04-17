package com.coding.displaydate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDateController{
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

		@RequestMapping("/date")
		public String date(Model model) {
			DateTimeFormatter dateObj = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
			LocalDateTime now = LocalDateTime.now();
			String date = now.format(dateObj);	
			model.addAttribute("date", date);
			return "date.jsp";
		}

		@RequestMapping("/time")
		public String time(Model model) {
			DateTimeFormatter timeObj = DateTimeFormatter.ofPattern("HH:mm a");
			LocalDateTime now = LocalDateTime.now();
			String time = now.format(timeObj);
			model.addAttribute("time", time);
			return "time.jsp";
		}
}