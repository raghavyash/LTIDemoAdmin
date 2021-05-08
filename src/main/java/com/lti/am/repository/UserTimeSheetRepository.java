package com.lti.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.am.entity.UserTimeSheetEntity;
@Repository
public interface UserTimeSheetRepository extends CrudRepository<UserTimeSheetEntity, Long>{
	@Query("select c from UserTimeSheetEntity c join  c.userEntityID u where u.customerId = :userId")
    List<UserTimeSheetEntity> getUserTimeSheetList(@Param("userId") Long userId);
}
