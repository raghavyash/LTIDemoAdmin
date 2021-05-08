package com.lti.am.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.am.model.UserMessageModel;
import com.lti.am.model.UserTimeSheetModel;
import com.lti.am.requestresponse.UserMessageRequest;
import com.lti.am.requestresponse.UserTimeSheetRequest;
import com.lti.am.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	

	@PostMapping(value = "/timesheet-save",headers = "Accept=application/json",
			consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> saveUserTimeSheet(@RequestBody UserTimeSheetRequest request) {
		Map<String, Object> response = new HashMap<String, Object>();
     
		Boolean customerData = userService.saveUserTimeSheet(request);
			if (customerData != null) {
				response.put("response_data", customerData);
				response.put("response_message", "successfully register Employee ");
				response.put("response_status", true);
			} else {
				response.put("response_message", "not register successfully !!! Please try again");
				response.put("response_status", true);
			}
		
		return response;
	}
	
	@PostMapping(value = "/timesheet-list",headers = "Accept=application/json",
			consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> listUserTimeSheet(@RequestBody UserTimeSheetRequest request) {
		Map<String, Object> response = new HashMap<String, Object>();
     
		List<UserTimeSheetModel> customerData = userService.getUserTimeSheetList(request);
			if (customerData != null) {
				response.put("response_data", customerData);
				response.put("response_message", "successfully register Employee ");
				response.put("response_status", true);
			} else {
				response.put("response_message", "not register successfully !!! Please try again");
				response.put("response_status", true);
			}
		
		return response;
	}
	
	@PostMapping(value = "/message-save",headers = "Accept=application/json",
			consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> updateEmployee(@RequestBody UserMessageRequest request) {
		Map<String, Object> response = new HashMap<String, Object>();
          
		  Boolean customerData = userService.saveUserMessage(request);
			if (customerData != null) {
				
				response.put("response_data", customerData);
				response.put("response_message", "successfully update Employee Data ");
				response.put("response_status", true);
			} else {
				response.put("response_message", "not register successfully !!! Please try again");
				response.put("response_status", true);
			}
		
		return response;
	}
	
	@PostMapping(value = "/message-list",headers = "Accept=application/json",
			consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> getMessageList(@RequestBody UserMessageRequest request) {
		Map<String, Object> response = new HashMap<String, Object>();
          
		List<UserMessageModel> customerData = userService.getUserMessageList(request);
			if (customerData != null) {
				
				response.put("response_data", customerData);
				response.put("response_message", "successfully update Employee Data ");
				response.put("response_status", true);
			} else {
				response.put("response_message", "not register successfully !!! Please try again");
				response.put("response_status", true);
			}
		
		return response;
	}
}
