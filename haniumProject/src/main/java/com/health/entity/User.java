package com.health.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	
	
	String userId;
	
	String userPwd;
	@Id
	String userName;

}

