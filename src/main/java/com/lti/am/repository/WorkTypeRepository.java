package com.lti.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.am.entity.WorkTypeEntity;

@Repository
public interface WorkTypeRepository extends JpaRepository<WorkTypeEntity, Long>{
	@Query("select c from WorkTypeEntity c where status='Active'")
    List<WorkTypeEntity> getWorkTypeActiveList();
}
