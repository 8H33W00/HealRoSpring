package com.health.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.health"})
@PropertySource("classpath:application.properties")
@ImportResource({"classpath*:applicationContext.xml"})
public class GraduateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduateProjectApplication.class, args);
	}

}