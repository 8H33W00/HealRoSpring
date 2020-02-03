package com.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
 
	@GetMapping("/")
	public ModelAndView main()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
		
	}
	
	
	@GetMapping("/heartDisease")
	public ModelAndView heartDisease()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("heart-disease");
		return mv;
		
	}
}
