package com.lti.am.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lti.am.entity.CustomerEntity;
import com.lti.am.entity.UserWorkItemEntity;
import com.lti.am.entity.WorkItemEntity;
import com.lti.am.entity.WorkTypeEntity;
import com.lti.am.model.UserWorkItemModel;
import com.lti.am.model.WorkItemModel;
import com.lti.am.model.WorkTypeModel;
import com.lti.am.requestresponse.UserWorkItemRequest;
import com.lti.am.requestresponse.WorkItemRequest;
import com.lti.am.requestresponse.WorkTypeRequest;

public class MasterMapper {

	/* Address Type Master Module Strat here */

	
	
	/*  work type module*/
	
	public static WorkTypeEntity SaveWorkTypeRequestToEntity(WorkTypeRequest request) {
		WorkTypeEntity entity = new WorkTypeEntity();
		entity.setWorkTypeName(request.getWorkTypeName());
		entity.setModifiedBy("Admin");
		entity.setModifiedDate(new Date());
		entity.setStatus("Active");
		entity.setDescription(request.getDescription());
		return entity;
	}

	public static WorkTypeModel WorkTypeEntityToModel(WorkTypeEntity entity) {
		WorkTypeModel model = new WorkTypeModel();
		model.setWorkTypeName(entity.getWorkTypeName());
		model.setStatus(entity.getStatus());
		
		model.setWorkTypeCode(entity.getWorkTypeCode());
		return model;
	}

	public static List<WorkTypeModel> WorkTypeListEntityToModelList(List<WorkTypeEntity> list) {
		List<WorkTypeModel> countryList = new ArrayList<WorkTypeModel>();
		if (list != null) {
			for (WorkTypeEntity entity : list) {
				WorkTypeModel model = new WorkTypeModel();
				model.setWorkTypeName(entity.getWorkTypeName());
				model.setStatus(entity.getStatus());
				model.setWorkTypeCode(entity.getWorkTypeCode());
				countryList.add(model);
			}
		}
		return countryList;
	}
	
/*  work Item module*/
	
	public static WorkItemEntity SaveWorkItemRequestToEntity(WorkItemRequest request) {
		WorkItemEntity entity = new WorkItemEntity();
		entity.setWorkItemName(request.getWorkItemName());
		entity.setModifiedBy("Admin");
		entity.setModifiedDate(new Date());
		entity.setStatus("Active");
		entity.setDescription(request.getDescription());
		WorkTypeEntity workTypeEntity = new WorkTypeEntity();
		workTypeEntity.setWorkTypeCode(request.getWorkTypeCode());
		entity.setWorkTypeEntity(workTypeEntity);
		return entity;
	}

	public static WorkItemModel WorkItemEntityToModel(WorkItemEntity entity) {
		WorkItemModel model = new WorkItemModel();
		model.setWorkItemName(entity.getWorkItemName());
		model.setStatus(entity.getStatus());
		
		model.setWorkItemCode(entity.getWorkItemCode());
		return model;
	}

	public static List<WorkItemModel> WorkItemListEntityToModelList(List<WorkItemEntity> list) {
		List<WorkItemModel> wList = new ArrayList<WorkItemModel>();
		if (list != null) {
			for (WorkItemEntity entity : list) {
				WorkItemModel model = new WorkItemModel();
				model.setWorkItemName(entity.getWorkItemName());
				model.setStatus(entity.getStatus());
				model.setWorkItemCode(entity.getWorkItemCode());
				wList.add(model);
			}
		}
		return wList;
	}
	
/* Assign User  work Item module*/
	
	public static UserWorkItemEntity SaveAssignWorkItemToUserRequestToEntity(UserWorkItemRequest request) {
		UserWorkItemEntity entity = new UserWorkItemEntity();
		
		
		entity.setModifiedBy("Admin");
		entity.setModifiedDate(new Date());
		CustomerEntity employeeEntity= new CustomerEntity();
		employeeEntity.setCustomerId(request.getUserId());
		entity.setUserId(employeeEntity);
		Set<WorkItemEntity> setWIRequest= new HashSet<WorkItemEntity>();
		Set<WorkItemRequest> workItemRequests=request.getWorkItemRequests();
		for(WorkItemRequest wir:workItemRequests) {
			WorkItemEntity workItemEntity= new WorkItemEntity();
			workItemEntity.setWorkItemCode(wir.getWorkItemCode());
			setWIRequest.add(workItemEntity);
		}
		entity.setWorkItemEntities(setWIRequest);
		return entity;
	}

	public static UserWorkItemModel GetAssignWorkItemToUserEntityToModel(UserWorkItemEntity entity) {
		UserWorkItemModel model = new UserWorkItemModel();
		model.setUserId(entity.getUserWorkItemId());
		Set<WorkItemEntity>  wtr= entity.getWorkItemEntities();
		Set<WorkItemRequest> setWIRequest= new HashSet<WorkItemRequest>();
		for(WorkItemEntity entity1:wtr) {
			WorkItemRequest workItemRequest = new WorkItemRequest();
			workItemRequest.setWorkItemName(entity1.getWorkItemName());
			setWIRequest.add(workItemRequest);
		}
		model.setWorkItemName(setWIRequest.toString());
		return model;
	}

	public static List<UserWorkItemModel> ListAssignWorkItemToUserEntityToModelList(List<UserWorkItemEntity> list) {
		List<UserWorkItemModel> wList = new ArrayList<UserWorkItemModel>();
		if (list != null) {
			for (UserWorkItemEntity entity : list) {
				UserWorkItemModel model = new UserWorkItemModel();
				model.setUserId(entity.getUserId().getCustomerId());
				Set<WorkItemEntity>  wtr= entity.getWorkItemEntities();
				Set<WorkItemRequest> setWIRequest= new HashSet<WorkItemRequest>();
				for(WorkItemEntity entity1:wtr) {
					WorkItemRequest workItemRequest = new WorkItemRequest();
					workItemRequest.setWorkItemName(entity1.getWorkItemName());
					setWIRequest.add(workItemRequest);
				}
				model.setWorkItemName(setWIRequest.toString());
				wList.add(model);
			}
		}
		return wList;
	}
}
