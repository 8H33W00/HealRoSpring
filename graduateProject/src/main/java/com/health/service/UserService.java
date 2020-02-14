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
	
	public boolean search(String userId)
	{
		if(userRepo.findByUserId(userId) != null)
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
		if(userRepo.findByUserId(user.getUserId()) != null)
		{
			User checkUser = userRepo.findByUserId(user.getUserId());
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
}
