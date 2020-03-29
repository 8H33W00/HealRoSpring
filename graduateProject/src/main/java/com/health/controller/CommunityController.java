package com.health.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.CoronaryTb;
import com.health.service.CoronaryTbService;

@Controller
public class CommunityController {
	
	@Autowired
	CoronaryTbService coronaryService;
	
	@GetMapping("/community")
	public ModelAndView community()
	{	
		List<CoronaryTb> coronaryList = coronaryService.findCoronaryTb();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community");
		mv.addObject("coronaryList",coronaryList);
		return mv;
		
	}
	
	
	@GetMapping("/view")
	public ModelAndView view(@RequestParam("id") int id)
	{	
		CoronaryTb coronary = coronaryService.findCoronaryTbById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("title",coronary.getTitle());
		mv.addObject("content",coronary.getContent());
		mv.addObject("nickname",coronary.getNickname());
		mv.addObject("id",coronary.getId());
		return mv;
		
	}
	
	@GetMapping("/deletePost")
	public ModelAndView deletePost(@RequestParam("id") int id)
	{	
		coronaryService.delete(id);
		List<CoronaryTb> coronaryList = coronaryService.findCoronaryTb();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community");
		mv.addObject("coronaryList",coronaryList);
		return mv;
		
	}

}
