package com.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.service.HospitalService;

@Controller
public class HospitalController {

	@GetMapping("/hospital_test")
	public ModelAndView hospitalTest()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hospital-test");
		return mv;
		
	}
}
