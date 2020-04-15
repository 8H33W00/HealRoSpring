package com.health.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	String hospitalCity;
	String hospitalImg;
	String hospitalName;
	String hospitalAddr;
	String hospitalWeb;
	String hospitalPhone;
	java.math.BigDecimal hospitalLatitude;
	java.math.BigDecimal hospitalLongitude;
	
}
