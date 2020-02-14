package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.health.entity.User;

public interface UserRepository extends JpaRepository<User,String> {
	
	
	@Query(value = "SELECT * FROM user A"
			+ "  WHERE A.USER_ID IN (:userId)", 
			nativeQuery = true)
	User findByUserId(@Param("userId")String userId);

}
