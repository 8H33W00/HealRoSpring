package com.health.restcontroller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.User;
import com.health.repository.UserRepository;
import com.health.service.UserService;


@RestController
public class MailRestController {

	@Autowired
	UserRepository userRepo;

	@Autowired 
	private MailSender sender;

	@GetMapping("/mail")
	public String sendMail( HttpSession session, HttpServletResponse response) 
	{ 
		String nickname = (String) session.getAttribute("userNickName");
		User user = userRepo.findByUserName(nickname); 
				
				
		SimpleMailMessage msg = new SimpleMailMessage(); 
	    msg.setFrom("HealRo@noreply"); 
	    msg.setTo(user.getUserEmail()); 
	    msg.setSubject("HealRo에서 보냅니다."); 
	    msg.setText("당뇨병으로 당신은 아프네요"); 
	    this.sender.send(msg); 
	    return "";
	    
	}
}
