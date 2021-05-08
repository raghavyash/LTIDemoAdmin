package com.lti.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.am.entity.WorkItemEntity;

@Repository
public interface WorkItemRepository extends JpaRepository<WorkItemEntity, Long>{
	@Query("select c from WorkItemEntity c where status='Active'")
    List<WorkItemEntity> getWorkItemActiveList();
}
