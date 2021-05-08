package com.lti.am.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.am.model.CustomerModel;
import com.lti.am.model.CustomerPasswordModel;
import com.lti.am.requestresponse.CustomerRequest;
import com.lti.am.services.CustomerService;

import antlr.StringUtils;
@RestController
@RequestMapping(value = "/CUST-AUTH")
public class CustomerController {
	/*@Autowired
	private JavaMailSender mailSender;*/
	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/SIGN-UP",headers = "Accept=application/json",
			consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> createUser(@RequestBody CustomerRequest request) {
		Map<String, Object> response = new HashMap<String, Object>();

		Boolean checkUserInDB = customerService.checkCustomerPresentInDB(request);
		if (checkUserInDB != true) {
			CustomerModel customerData = customerService.saveCustomerProfileData(request);
			if (customerData != null) {
				UUID uuid = UUID.randomUUID();
				String token = uuid.toString().replace("-", "");
				customerData.setToken(token);
				response.put("response_data", customerData);
				//response.put("token", token);
				response.put("user_type", customerData.getUserType());
				response.put("response_message", "successfully register Customer ");
				response.put("response_status", true);
			} else {
				response.put("response_message", "not register successfully !!! Please try again");
				response.put("response_status", true);
			}
		} else {
			response.put("response_message", "username is already register !!! Please reset your password");
			response.put("response_status", false);
		}
		return response;
	}
	@PostMapping(value = "/UPDATE-SIGN-UP" ,headers = "Accept=application/json",
			consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> updateCustomerDetail(@RequestBody CustomerRequest request) {
		Map<String, Object> response = new HashMap<String, Object>();

		Boolean checkUserInDB = customerService.checkCustomerPresentInDB(request);
		if (checkUserInDB) {
			CustomerModel model2 = customerService.updateCustomerProfileData(request);
			if (model2 != null) {
				response.put("response_data", model2);
				response.put("response_message", "successfully update register Customer ");
				response.put("response_status", true);
			} else {
				response.put("response_message", "not update register successfully !!! Please try again");
				response.put("response_status", true);
			}
		} else {
			response.put("response_message", "username is not register !!! Please signUp");
			response.put("response_status", false);
		}
		return response;
	}
	@PostMapping(value = "/SIGN-IN",headers = "Accept=application/json",
			consumes= MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> checkCustomerLogin(@RequestBody CustomerRequest request, HttpSession session) {
		Map<String, Object> response = new HashMap<String, Object>();
		
		if (request != null) {
			Boolean result = customerService.checkCustomerLogin(request);
			if (result) {
				CustomerModel customerData = customerService.getCustomerDetail(request);
				UUID uuid = UUID.randomUUID();
				String token = uuid.toString().replace("-", "");
				customerData.setToken(token);
				response.put("response_data", customerData);
				//response.put("token", token);
				response.put("user_type", customerData.getUserType());
				response.put("response_message", "successfully login");
				response.put("response_status", true);
			} else {
				response.put("response_message", "username and password is  invalid!!!!!");
				response.put("response_status", false);
			}
		} else {
			response.put("response_message", "username and password is blank ");
			response.put("response_status", false);
		}
		return response;
	}

	@PostMapping(value = "/FPWD", headers = "Accept=application/json",
			consumes= MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> forgotPassword(@RequestBody CustomerRequest request) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean checkUserInDB = customerService.checkCustomerPresentInDB(request);
		if (checkUserInDB != true) {
			CustomerPasswordModel userModelForPassword = customerService.getCustomerForgetPassword(request);
			if (userModelForPassword != null) {
				response.put("response_message", "Email send successfully");
				response.put("response_status", true);
			} else {
				response.put("response_message", "not send successfully !!! Please try again");
				response.put("response_status", true);
			}
		} else {
			response.put("response_message", "Email/username is not register !!! Please signup");
			response.put("response_status", false);
		}
		return response;
	}

	
}
