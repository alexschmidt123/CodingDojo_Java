package com.coding.scamazon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScamController {
	@RequestMapping("")
	public String index() {
		return "/WEB-INF/index.jsp";
	}
}
