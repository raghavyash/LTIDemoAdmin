package com.lti.am.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.am.entity.CustomerEntity;
import com.lti.am.mapper.CustomerMapper;
import com.lti.am.model.CustomerModel;
import com.lti.am.model.CustomerPasswordModel;
import com.lti.am.repository.CustomerRepository;
import com.lti.am.requestresponse.CustomerRequest;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Boolean checkCustomerPresentInDB(CustomerRequest request) {
		CustomerEntity entity= customerRepository.searchCustomerByUserName(request.getEmail());
		if(entity!= null) {
			return true;
		}
		return false;
	}

	
	public CustomerModel saveCustomerProfileData(CustomerRequest request) {
		CustomerEntity entity=CustomerMapper.CustomerSaveRequestToEntity(request);
		CustomerEntity entity1= customerRepository.save(entity);
		if(entity1!= null) {
			return CustomerMapper.CustomerEntityToModel(entity1);
		}
		return null;
	}

	
	public CustomerModel updateCustomerProfileData(CustomerRequest request) {
		CustomerEntity entity=customerRepository.getCustomerDetailByUserName(request.getEmail());
		CustomerEntity returnEntity=CustomerMapper.CustomerUpdateRequestToEntity(entity,request);
		CustomerEntity entity1= customerRepository.save(returnEntity);
		if(entity1!= null) {
			return CustomerMapper.CustomerEntityToModel(entity1);
		}
		return null;
	}
	
	public Boolean checkCustomerLogin(CustomerRequest request) {
		CustomerEntity entity= customerRepository.checkLoginCustomer(request.getEmail(), request.getPassword());
		if(entity!= null) {
			return true;
		}
		return false;
	}

	
	public CustomerModel getCustomerDetail(CustomerRequest request) {
		CustomerEntity entity= customerRepository.getCustomerDetailByUserName(request.getEmail());
		if(entity!= null) {
			return CustomerMapper.CustomerEntityToModel(entity);
		}
		return null;
	}

	
	public CustomerPasswordModel getCustomerForgetPassword(CustomerRequest request) {
		CustomerEntity entity= customerRepository.searchCustomerByUserName(request.getEmail());
		if(entity!= null) {
			return CustomerMapper.CustomerPasswordEntityToModel(entity);
		}
		return null;
	}

}
