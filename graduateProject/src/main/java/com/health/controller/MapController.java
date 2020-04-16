package com.health.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.Hospital;
import com.health.repository.HospitalRepository;

@Controller
public class MapController {
	
	@Autowired
	HospitalRepository hosRepo;
	
	
	@GetMapping("/map")
	public ModelAndView map() {
		
		List<Hospital> hospList = hosRepo.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("map");
		mv.addObject("hospList", hospList);
		
		return mv;
	}
}
