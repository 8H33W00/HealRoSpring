package com.health.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.health.entity.User;

public interface UserRepository extends JpaRepository<User,String> {
	
	
	@Query(value = "SELECT * FROM user A"
			+ "  WHERE A.USER_ID IN (:userId)", 
			nativeQuery = true)
	User findByUserId(@Param("userId")String userId);
	
	@Query(value = "SELECT * FROM user A"
			+ "  WHERE BINARY(A.USER_ID) IN (:userId)", 
			nativeQuery = true)
	User findByUserId2(@Param("userId")String userId);
	
	@Query(value = "SELECT * FROM user A"
			+ "  WHERE A.USER_NAME IN (:userName)", 
			nativeQuery = true)
	User findByUserName(@Param("userName")String userName);
	
}
