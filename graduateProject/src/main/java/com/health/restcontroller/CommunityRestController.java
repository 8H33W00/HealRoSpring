package com.health.restcontroller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.CardioTb;
import com.health.entity.Comment;
import com.health.entity.CoronaryTb;
import com.health.entity.DiabetesTb;
import com.health.entity.User;
import com.health.repository.CardioRepository;
import com.health.service.CardioService;
import com.health.service.CommentService;
import com.health.service.CoronaryTbService;
import com.health.service.DiabeteService;


@RestController
public class CommunityRestController {
	
	@Autowired
	CoronaryTbService coronaryService;
	
	@Autowired
	DiabeteService diaService;
	
	@Autowired
	CardioService cardioService;
	
	
	@Autowired
	CommentService comService;

	
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
	
	@PostMapping("/createCardio")
	public int createCardio(@RequestBody CardioTb cardio)
	{
		Date now = new Date(System.currentTimeMillis());
		cardio.setTime(now);
		cardioService.create(cardio);
		return 0;
		
	}
	
	@PostMapping("/createDiabete")
	public int createDiabete(@RequestBody DiabetesTb dia)
	{
		Date now = new Date(System.currentTimeMillis());
		dia.setTime(now);
		diaService.create(dia);
		return 0;
		
	}
	
	
	@PostMapping("/createComment")
	public int createDiabete(@RequestBody Comment com)
	{
		Date now = new Date(System.currentTimeMillis());
		com.setTime(now);
		comService.create(com);
		return 0;
		
	}
	
	@PostMapping("/deleteComment")
	public int deleteComment(@RequestBody int id)
	{
		
		comService.deleteByid(id);
		return 0;
		
	}
	
}
