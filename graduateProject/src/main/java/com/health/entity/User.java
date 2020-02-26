package com.health.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	String userId;
	
	String userPwd;
	String userName;

}

public class Odd {
	
	@Id
	String userNickname;
	
	float heartDisease;
	float diabetes;
	float breastCancer;
	float brainDisease;
	float vascularDisease;
	
}