package com.kuchejda.maciej.controller;


import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	 @RequestMapping("/login")  
	 public ModelAndView getLoginForm( ) {  
		return new ModelAndView("login");  
	 }  
}
