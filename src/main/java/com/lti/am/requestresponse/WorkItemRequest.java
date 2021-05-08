package com.lti.am.requestresponse;

public class WorkItemRequest {
	private Long workItemCode;
	private String workItemName;
	private Long workTypeCode;
	private String status;
	private String description;
	private Long userId;
	private String userName;

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "WorkItemRequest [workItemName=" + workItemName + "]";
	}

	public Long getWorkItemCode() {
		return workItemCode;
	}

	public void setWorkItemCode(Long workItemCode) {
		this.workItemCode = workItemCode;
	}

	public String getWorkItemName() {
		return workItemName;
	}

	public void setWorkItemName(String workItemName) {
		this.workItemName = workItemName;
	}

	public Long getWorkTypeCode() {
		return workTypeCode;
	}

	public void setWorkTypeCode(Long workTypeCode) {
		this.workTypeCode = workTypeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
