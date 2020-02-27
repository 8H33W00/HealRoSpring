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
	

	@GetMapping("/vascular")
	public ModelAndView vascular()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("vascular-disease");
		return mv;
	}
	
	@GetMapping("/diabetes")
	public ModelAndView diabetes()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("diabetes");
		return mv;
		
	}
	
	
	
	@GetMapping("/heartDisease")
	public ModelAndView heartDisease()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("heart-disease");
		return mv;
		
	}
	
	
	@GetMapping("/predictHeartDisease")
	public ModelAndView predictHeartDisease()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("predict-heart-disease");
		return mv;
		
	}
	
	@GetMapping("/predictHeartDisease2")
	public ModelAndView predictHeartDisease2()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("predict-heart-disease2");
		return mv;
		
	}
	
	
	@GetMapping("/predictDiabetes")
	public ModelAndView predictDiabetes()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("predict-diabetes");
		return mv;
		
	}
	
	@GetMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@GetMapping("/mypage")
	public ModelAndView mypage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypage");
		return mv;
	}
}
