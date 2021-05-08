package com.lti.am.services;

import com.lti.am.model.CustomerModel;
import com.lti.am.model.CustomerPasswordModel;
import com.lti.am.requestresponse.CustomerRequest;

public interface CustomerService {
	Boolean checkCustomerPresentInDB(CustomerRequest request);
	CustomerModel saveCustomerProfileData(CustomerRequest request);
	CustomerModel updateCustomerProfileData(CustomerRequest request);
	Boolean checkCustomerLogin(CustomerRequest request);
	CustomerModel getCustomerDetail(CustomerRequest request);
	CustomerPasswordModel getCustomerForgetPassword(CustomerRequest request);
	
}
