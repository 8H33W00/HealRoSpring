package com.health.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.User;
import com.health.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public boolean create(User user)
	{
		System.out.println("+++++++++++++++"+user);
		try {
			userRepo.save(user);
			return true;
		}
		catch(Exception e){
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean searchId(String userId)
	{
		if(userRepo.findByUserId(userId) != null)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean searchName(String userName)
	{
		if(userRepo.findByUserName(userName) != null)
		{
			return true;
		}
		
		return false;
	}
	
	
	public User searchObj(String userId)
	{
		return userRepo.findByUserId(userId);
	}
	
	public int login(User user)
	{
		System.out.println("----------------"+user);
		if(userRepo.findByUserId2(user.getUserId()) != null)
		{
			User checkUser = userRepo.findByUserId2(user.getUserId());
			System.out.println("----------------"+checkUser);
			if(user.getUserPwd().equals(checkUser.getUserPwd()))
			{
				return 1;
			}
			return 2;
		}
		else
		{
			return 3;
		}
	}
	
	public String findPwd(User user)
	{
		System.out.println("----------------"+user);
		if(userRepo.findByUserId2(user.getUserId()) != null)
		{
			User checkUser = userRepo.findByUserId2(user.getUserId());
			System.out.println("----------------"+checkUser);
			if(user.getUserFind().equals(checkUser.getUserFind()))
			{
				return checkUser.getUserPwd();
			}
			return "Password Query is not correct";
		}
		else
		{
			return "There is no such ID";
		}
	}
	
	public void recordResult(int diseaseType, Float odd, String userNickName) {
		if(diseaseType == 0) {
			userRepo.recordResultCardio(odd, userNickName);
		}
		else if(diseaseType == 1) {
			userRepo.recordResultCoronary(odd, userNickName);
		}
		else if(diseaseType == 2) {
			userRepo.recordResultDiabete(odd, userNickName);
		}
		else if(diseaseType == 10) {
			userRepo.recordResultCardioPast(odd, userNickName);
		}
		else if(diseaseType == 11) {
			userRepo.recordResultCoronaryPast(odd, userNickName);
		}
		else if(diseaseType == 12) {
			userRepo.recordResultDiabetePast(odd, userNickName);
		}
	}
}