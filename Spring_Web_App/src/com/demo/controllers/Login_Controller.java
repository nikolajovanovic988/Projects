package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login_Controller {

	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public ModelAndView loadLoginPage() {
//		
//		ModelAndView mav = new ModelAndView("login");
//		
//		return mav;
//	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loadLoginPage() {
		return "login";
	}
}
