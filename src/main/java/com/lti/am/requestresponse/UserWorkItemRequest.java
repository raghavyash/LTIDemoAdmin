package com.lti.am.requestresponse;

import java.util.HashSet;
import java.util.Set;

public class UserWorkItemRequest {
	private Long id;
	private Long userId;
	private Set<WorkItemRequest> workItemRequests =new HashSet<WorkItemRequest>();

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
