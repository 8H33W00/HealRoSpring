package com.health.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class DiabetesTb {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	String nickname;
	String title;
	String content;
	Date time;

}

