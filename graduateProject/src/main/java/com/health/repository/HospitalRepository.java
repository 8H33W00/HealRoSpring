package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.health.entity.Hospital;
import com.health.entity.User;

public interface HospitalRepository extends JpaRepository<Hospital,String> {
	
//	Hospital findByField(@Param())

}
