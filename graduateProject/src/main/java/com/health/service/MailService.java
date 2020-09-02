package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.CardioResult;
import com.health.entity.CoronaryResult;
import com.health.entity.DiabetesResult;
import com.health.entity.User;
import com.health.repository.CardioResultRepository;
import com.health.repository.CoronaryResultRepository;
import com.health.repository.DiabetesResultRepository;

@Service
public class MailService {
	
	@Autowired
	CoronaryResultRepository corepo;
	@Autowired
	DiabetesResultRepository diarepo;
	@Autowired
	CardioResultRepository carepo;
	
	
	public String greetingMessage(User user)
	{
		String message = "To, " + user.getUserName() + "\n"
				+ "Hi. This is HealRo. We are sending you the results of the disease prediction at your request.\n"
				+ "This results are predicted through machine learning and have more than 80% accuracy.\n"
				+ "If the results are close to average, maintain your current lifestyle,\n"
				+ "or get some advice from the results guide on HealRo MyPage to improve your lifestyle.\n"
				+ "However, if the results are higher than expected or worse,\n"
				+ "you should visit the hospital and consult with a professional doctor.\n"
				+ "HealRo offers a service that recommends a professional hospital close to you.\n"
				+ "And you can get information from similar people through the HealRo community.\n"
				+ "Share your health tips through the community and try to improve your health status which is result recorded on MyPage.\n\n"
				+ "Thank you for using the HealRo service!\n";
		return message;
	}
	
	public String coronaryContent(User user)
	{
		CoronaryResult core = corepo.findByUserName(user.getUserName()); 
		if(core.getRecentResult() != null)
		{
			String message = "percentage of getting a Coronary Artery disease in the future : " + core.getRecentResult() +" %\n" ;
			
			return message;
		}
		return "No results for Coronary Artery disease.\n" + 
				"Get prediction service through the HealRo.\n";
	}
	
	public String diabeteContent(User user)
	{
		DiabetesResult diare = diarepo.findByUserName(user.getUserName());
		if(diare.getRecentResult() != null)
		{
			String message = "percentage of getting a Diabetes disease in the future : " + diare.getRecentResult() +" %\n" ;
			
			return message;
		}
		return "No results for Diabetes disease.\n" + 
		"Get prediction service through the HealRo.\n";
	}
	
	public String cadioContent(User user)
	{
		
		CardioResult care = carepo.findByUserName(user.getUserName());
		if(care.getRecentResult() != null)
		{
			String message = "percentage of getting a Cardiovascular disease in the future : " + care.getRecentResult() +" %\n" ;
			
			return message;
		}
		return "No results for Cardiovascular disease.\n" + 
		"Get prediction service through the HealRo.\n";
	}

}
