package com.lti.am.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.am.entity.CustomerEntity;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
	@Query("select c from CustomerEntity c where c.email = :email and c.password=:password")
	CustomerEntity checkLoginCustomer(@Param("email") String email, @Param("password") String password);
	@Query("select c from CustomerEntity c where c.email = :email")
	CustomerEntity searchCustomerByUserName(@Param("email") String email);
	@Query("select c from CustomerEntity c where c.email = :email")
	CustomerEntity getCustomerDetailByUserName(@Param("email") String email);
}
