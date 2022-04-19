package com.coding.counter;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
 
 @RequestMapping("/")
 public String index(HttpSession session) {
	 if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
		 	session.setAttribute("count", 0);
			}
			else {
			// increment the count by 1 using getAttribute and setAttribute
				Integer currentCount = (Integer) session.getAttribute("count");
				session.setAttribute("count", currentCount+1);
			}
     return "index.jsp";
 }
 
 @RequestMapping("/reset")
 public String reset(HttpSession session) {
	 session.setAttribute("count", 0);
	 return "counter.jsp";
 }
 
 @RequestMapping("/counter")
 public String counter() {
	return "counter.jsp";
 }
}
