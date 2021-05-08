package com.lti.am.services;

import java.util.List;

import com.lti.am.model.GroupTypeModel;
import com.lti.am.model.UserWorkItemModel;
import com.lti.am.model.WorkItemModel;
import com.lti.am.model.WorkTypeModel;
import com.lti.am.requestresponse.UserWorkItemRequest;
import com.lti.am.requestresponse.WorkItemRequest;
import com.lti.am.requestresponse.WorkTypeRequest;

public interface AdminService {
	Boolean saveWorkTypeData(WorkTypeRequest request);
	WorkTypeModel getWorkTypeDetail(WorkTypeRequest request);
	List<WorkTypeModel> getActiveWorkTypeList();
	
	Boolean saveWorkItemData(WorkItemRequest request);
	WorkItemModel getWorkItemDetail(WorkItemRequest request);
	List<WorkItemModel> getActiveWorkItemList();
	
	Boolean userWorkItemDataSave(UserWorkItemRequest request);
	UserWorkItemModel userWorkItemDetail(UserWorkItemRequest request);
	List<UserWorkItemModel> userWorkItemModelList(UserWorkItemRequest request);
	
	
	
}
