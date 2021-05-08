package com.lti.am.mapper;

import com.lti.am.entity.CustomerEntity;
import com.lti.am.model.CustomerModel;
import com.lti.am.model.CustomerPasswordModel;
import com.lti.am.requestresponse.CustomerRequest;

public class CustomerMapper {
public static  CustomerEntity CustomerSaveRequestToEntity(CustomerRequest request) {
	CustomerEntity entity= new CustomerEntity();
	entity.setEmail(request.getEmail());
	entity.setFirstName(request.getFirstName());
	entity.setLastName(request.getLastName());
	entity.setMobile(request.getMobile());
	entity.setPassword(request.getPassword());
	entity.setStatus("Active");
	entity.setUserType(request.getUserType());
	return entity;
}
public static  CustomerEntity CustomerUpdateRequestToEntity(CustomerEntity entity ,CustomerRequest request) {
	entity.setEmail(request.getEmail());
	entity.setFirstName(request.getFirstName());
	entity.setLastName(request.getLastName());
	entity.setMobile(request.getMobile());
	return entity;
}

public static  CustomerModel CustomerEntityToModel(CustomerEntity entity) {
	CustomerModel model= new CustomerModel();
	model.setEmail(entity.getEmail());
	model.setFirstName(entity.getFirstName());
	model.setLastName(entity.getLastName());
	model.setMobile(entity.getMobile());
	model.setStatus(entity.getStatus());
	model.setUserType(entity.getUserType());
	model.setCustomerId(entity.getCustomerId());
	return model;
}
public static  CustomerPasswordModel CustomerPasswordEntityToModel(CustomerEntity entity) {
	CustomerPasswordModel model= new CustomerPasswordModel();
	model.setPassword(entity.getPassword());
	return model;
}
}
