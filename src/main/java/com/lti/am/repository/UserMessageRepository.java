package com.lti.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lmax.disruptor.Cursored;
import com.lti.am.entity.UserMessageEntity;


public interface UserMessageRepository extends  CrudRepository<UserMessageEntity, Long>{
	@Query("select c from UserMessageEntity c join c.toUserEntityID u where u.customerId = :userId")
    List<UserMessageEntity> getUserMessageList(@Param("userId") Long userId);
}
