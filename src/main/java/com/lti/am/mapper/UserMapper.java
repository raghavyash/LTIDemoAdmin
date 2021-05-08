package com.lti.am.mapper;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lti.am.entity.CustomerEntity;
import com.lti.am.entity.UserMessageEntity;
import com.lti.am.entity.UserTimeSheetEntity;
import com.lti.am.entity.WorkItemEntity;
import com.lti.am.model.UserMessageModel;
import com.lti.am.model.UserTimeSheetModel;
import com.lti.am.requestresponse.UserMessageRequest;
import com.lti.am.requestresponse.UserTimeSheetRequest;
import com.lti.am.utils.DateUtils;

public class UserMapper {
	
	public static  UserTimeSheetEntity UserTimeSheetSaveRequestToEntity(UserTimeSheetRequest request) throws ParseException {
		UserTimeSheetEntity entity= new UserTimeSheetEntity();
		entity.setHours(request.getHours());
		entity.setModifiedBy("Raghav");
		entity.setModifiedDate(new Date());
		entity.setTimeSheetDate(DateUtils.convertStringToDate(request.getTimesheetDate()));
		CustomerEntity customerEntity= new CustomerEntity();
		customerEntity.setCustomerId(request.getUserId());
		entity.setUserEntityID(customerEntity);
		WorkItemEntity workItemEntity= new  WorkItemEntity();
		workItemEntity.setWorkItemCode(request.getWorkItemCode());
		entity.setWorkItemEntities(workItemEntity);
		return entity;
	}
	

	
	
	public static List<UserTimeSheetModel> UserTimeSheetListEntityToModelList(List<UserTimeSheetEntity> list) {
		List<UserTimeSheetModel> empList = new ArrayList<UserTimeSheetModel>();
		if (list != null) {
			for (UserTimeSheetEntity entity : list) {
				UserTimeSheetModel model = new UserTimeSheetModel();
				model.setHours(entity.getHours());
				model.setTimesheetDate(DateUtils.convertDateTimeDateToString(entity.getModifiedDate()));
				model.setUserName(entity.getUserEntityID().getFirstName()+" "+entity.getUserEntityID().getLastName());
				model.setWorkItemName(entity.getWorkItemEntities().getWorkItemName());
				model.setWorkItemCode(entity.getWorkItemEntities().getWorkItemCode());
				empList.add(model);
			}
		}
		return empList;
	}
	
	public static  UserMessageEntity UserMessageSaveRequestToEntity(UserMessageRequest request) throws ParseException {
		UserMessageEntity entity= new UserMessageEntity();
		entity.setMessage(request.getMessage());
		entity.setModifiedBy("Raghav");
		entity.setModifiedDate(new Date());
		entity.setMessageDate(new Date());
		CustomerEntity toUserEntity= new CustomerEntity();
		toUserEntity.setCustomerId(request.getToUserID());
		entity.setToUserEntityID(toUserEntity);
		CustomerEntity fromUserEntity= new CustomerEntity();
		fromUserEntity.setCustomerId(request.getFromUserID());
		entity.setFromUserEntityID(fromUserEntity);
		
		
		return entity;
	}
	
	public static List<UserMessageModel> UserMessageListEntityToModelList(List<UserMessageEntity> list) {
		List<UserMessageModel> empList = new ArrayList<UserMessageModel>();
		if (list != null) {
			
			for (UserMessageEntity entity : list) {
				UserMessageModel model = new UserMessageModel();
				model.setMessage(entity.getMessage());
				//model.setMessageDate(DateUtils.convertDateTimeDateToString(entity.getMessageDate()));
				model.setReceiverUserName(entity.getToUserEntityID().getFirstName()+" "+entity.getToUserEntityID().getLastName());
				model.setSenderUserName(entity.getFromUserEntityID().getFirstName()+" "+entity.getFromUserEntityID().getLastName());
				empList.add(model);
			}
		}
		return empList;
	}
}
