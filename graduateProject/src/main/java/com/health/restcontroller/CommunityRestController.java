package com.health.restcontroller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.CoronaryTb;
import com.health.entity.User;
import com.health.service.CoronaryTbService;


@RestController
public class CommunityRestController {
	
	@Autowired
	CoronaryTbService coronaryService;

	
	@GetMapping("/post")
	public ModelAndView post(@RequestParam("type") String type) {
		ModelAndView mv = new ModelAndView();
		System.out.println("---------------"+type);
		mv.setViewName("post");
		mv.addObject("type",type);
		return mv;
	}
	
	@PostMapping("/createCoronary")
	public int createCoronary(@RequestBody CoronaryTb coro)
	{
		Date now = new Date(System.currentTimeMillis());
		coro.setTime(now);
		coronaryService.create(coro);
		return 0;
		
	}
}
