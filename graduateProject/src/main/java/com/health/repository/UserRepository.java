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
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user A"
			+" SET A.(:disease) = (:odd)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResult(@Param("odd")Float odd, @Param("userName")String userName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user A"
			+" SET A.CORONARY = (:odd)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultCoronary(@Param("odd")Float odd, @Param("userName")String userName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user A"
			+" SET A.DIABETE = (:odd)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultDiabete(@Param("odd")Float odd, @Param("userName")String userName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user A"
			+" SET A.CARDIO = (:odd)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultCardio(@Param("odd")Float odd, @Param("userName")String userName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user A"
			+" SET A.CORONARY_PAST = (:odd)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultCoronaryPast(@Param("odd")Float odd, @Param("userName")String userName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user A"
			+" SET A.DIABETE_PAST = (:odd)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultDiabetePast(@Param("odd")Float odd, @Param("userName")String userName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user A"
			+" SET A.CARDIO_PAST = (:odd)"
			+" WHERE A.USER_NAME = (:userName)",nativeQuery = true)
	void recordResultCardioPast(@Param("odd")Float odd, @Param("userName")String userName);
}
