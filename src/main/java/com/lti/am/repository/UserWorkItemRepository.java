package com.lti.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.am.entity.UserWorkItemEntity;


public interface UserWorkItemRepository extends JpaRepository<UserWorkItemEntity, Long>{
	@Query("select c from UserWorkItemEntity c join c.userId u where u.customerId = :userId")
    List<UserWorkItemEntity> getAssignUserWorkItemList(@Param("userId") Long userId);
	
	@Query("select c from UserWorkItemEntity c join c.userId u where u.customerId = :userId")
    UserWorkItemEntity getUserWorkItemDetail(@Param("userId") Long userId);
}
