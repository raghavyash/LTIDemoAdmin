package com.lti.am.model;

import java.util.Set;

import com.lti.am.requestresponse.WorkItemRequest;

public class UserWorkItemModel {
	private Long id;
	private Long userId;
	private Set<WorkItemRequest> workItemRequests;
    private String UserName;
    private String WorkItemName;
    private Set<String> workItemNameList;
    
    
	public Set<String> getWorkItemNameList() {
		return workItemNameList;
	}

	public void setWorkItemNameList(Set<String> workItemNameList) {
		this.workItemNameList = workItemNameList;
	}

	public String getWorkItemName() {
		return WorkItemName;
	}

	public void setWorkItemName(String workItemName) {
		WorkItemName = workItemName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Set<WorkItemRequest> getWorkItemRequests() {
		return workItemRequests;
	}

	public void setWorkItemRequests(Set<WorkItemRequest> workItemRequests) {
		this.workItemRequests = workItemRequests;
	}
}
