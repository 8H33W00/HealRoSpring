package com.health.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.repository.HospitalRepository;
import com.health.service.HospitalService;
import com.health.entity.Hospital;

@Controller
public class HospitalController {

	@Autowired
	HospitalRepository hosRepo;
	
	@GetMapping("/hospital_https")
	public ModelAndView https(){
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("check", 1);
		mv.setViewName("hospital_https");
		
		return mv;
	}
	
	@GetMapping("/mypage_vascular")
	public ModelAndView mypageVascular()
	{
		List<Hospital> hospList = hosRepo.findAll();
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypage_vascular");
		mv.addObject("hospList", hospList);
		
		return mv;
	}
}
