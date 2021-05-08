package com.lti.am.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.am.model.UserWorkItemModel;
import com.lti.am.model.WorkItemModel;
import com.lti.am.model.WorkTypeModel;
import com.lti.am.requestresponse.UserWorkItemRequest;
import com.lti.am.requestresponse.WorkItemRequest;
import com.lti.am.requestresponse.WorkTypeRequest;
import com.lti.am.services.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	
		
	/*work Type Module*/ 
	
	@PostMapping(value = "/work_type_save", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveWorkType(@RequestBody WorkTypeRequest request, HttpSession session) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean result = adminService.saveWorkTypeData(request);
		if (result != null) {
			response.put("response_data", result);
			response.put("response_message", "Successfully save Address Type");
			response.put("response_status", true);
		} else {
			response.put("response_message", "not successfully save Data !!! Please try again");
			response.put("response_status", false);
		}
	
		return response;
	}
	@PostMapping(value = "/work_type_list")
	public @ResponseBody Map<String, Object> getWorkTypeList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<WorkTypeModel> result = adminService.getActiveWorkTypeList();
		if (result != null) {
			response.put("response_data", result);
			response.put("response_message", "Work Type List= "+result.size());
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Work Type List");
			response.put("response_status", false);
		}
	
		return response;
	}
	
	@PostMapping(value = "/work_item_save", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> saveWorkItem(@RequestBody WorkItemRequest request, HttpSession session) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean result = adminService.saveWorkItemData(request);
		if (result != null) {
			response.put("response_data", result);
			response.put("response_message", "Successfully save Address Type");
			response.put("response_status", true);
		} else {
			response.put("response_message", "not successfully save Data !!! Please try again");
			response.put("response_status", false);
		}
	
		
		return response;
	}
	
	@PostMapping(value = "/work_item_list", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getWorkItemList() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<WorkItemModel> result = adminService.getActiveWorkItemList();
		if (result != null) {
			response.put("response_data", result);
			response.put("response_message", "Work Item List= "+result.size());
			response.put("response_status", true);
		} else {
			response.put("response_message", "Not Available Work Item List");
			response.put("response_status", false);
		}
	
		return response;
	}
	
	@PostMapping(value = "/assign_wi_user", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> assignWorkItemUser(@RequestBody UserWorkItemRequest request, HttpSession session) {
		Map<String, Object> response = new HashMap<String, Object>();
		Boolean result = adminService.userWorkItemDataSave(request);
		if (result != null) {
			response.put("response_data", result);
			response.put("response_message", "Successfully save Assign User Work Item");
			response.put("response_status", true);
		} else {
			response.put("response_message", "not successfully save Data !!! Please try again");
			response.put("response_status", false);
		}
	
		
		return response;
	}
	
	@PostMapping(value = "/assign_wi_user_list", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> assignWorkItemUserList(@RequestBody UserWorkItemRequest request, HttpSession session) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<UserWorkItemModel> result = adminService.userWorkItemModelList(request);
		if (result != null) {
			response.put("response_data", result);
			response.put("response_message", "User Work Item List Detail");
			response.put("response_status", true);
		} else {
			response.put("response_message", "not avaliable Data !!! Please try again");
			response.put("response_status", false);
		}
	
		
		return response;
	}
	
	@PostMapping(value = "/get_assign_wi_detail", headers = "Accept=application/json")
	public @ResponseBody Map<String, Object> getAssignWorkItemUserDetail(@RequestBody UserWorkItemRequest request, HttpSession session) {
		Map<String, Object> response = new HashMap<String, Object>();
		UserWorkItemModel result = adminService.userWorkItemDetail(request);
		if (result != null) {
			response.put("response_data", result);
			response.put("response_message", "User Work Item  Detail");
			response.put("response_status", true);
		} else {
			response.put("response_message", "not available Data !!! Please try again");
			response.put("response_status", false);
		}
	
		
		return response;
	}
}
