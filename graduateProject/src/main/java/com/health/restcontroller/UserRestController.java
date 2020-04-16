package com.health.restcontroller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.User;
import com.health.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;
	
	/**
	 * 
	 * @param user
	 * @return
	 * 1 : success
	 * 2 : Already Exist
	 * 3 : Fail / Maybe Not English NickName
	 */
	
	@PostMapping("/signUp")
	public int signUp(@RequestBody User user)
	{
		int response = 0;
		if(userService.searchId(user.getUserId()))
		{
			response += 2;
		}
		if(userService.searchName(user.getUserName()))
		{
			response += 3;
		}
		
		if(response != 0) {
			return response;
		}
		
		boolean check = userService.create(user);
		if(check)
		{
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@PostMapping("/signIn")
	public int signIn(@RequestBody User user, HttpSession session, HttpServletResponse response)
	{
		int check = userService.login(user);
		if(check == 1)
		{
			session.setAttribute("userNickName", userService.searchObj(user.getUserId()).getUserName());
		}
		return check;
		
	}
	
	
	@PostMapping("/findPwd")
	public String findPwd(@RequestBody User user)
	{
		String msg = userService.findPwd(user);
		return msg;
		
	}
	
	@PostMapping("/recordResult")
	public String recordResult(@RequestBody Map<String,String> info, HttpSession session, HttpServletResponse response)
	{
		String userId = (String) session.getAttribute("userNickName");
		String diseaseName = info.get("disease");
		String odd = info.get("odd");
		Float result = Float.valueOf(odd).floatValue();
		int diseaseType = -1;
		Float past = null;
		System.out.println(userId);
		System.out.println(diseaseName);
		System.out.println(result);
		
		if(diseaseName.equals("cardio")) {
			diseaseType = 0;
			past = (Float) session.getAttribute("cardio");
			System.out.println(past);
			if(past != null) {
				userService.recordResult(10,past,userId);
				session.setAttribute("cardioPast", past);
			}
			session.setAttribute("cardio", result);
		}
		else if(diseaseName.equals("coronary")) {
			diseaseType = 1;
			past = (Float) session.getAttribute("coronary");
			if(past != null) {
				userService.recordResult(11,past,userId);
				session.setAttribute("coronaryPast", past);
			}
			session.setAttribute("coronary", result);
		}
		else if(diseaseName.equals("diabete")) {
			diseaseType = 2;
			past = (Float) session.getAttribute("diabete");
			if(past != null) {
				userService.recordResult(12,past,userId);
				session.setAttribute("diabetePast", past);
			}
			session.setAttribute("diabete", result);
		}
		
		userService.recordResult(diseaseType,result,userId);
		return userId;
		
	}
}