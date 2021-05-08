package com.lti.am.model;

public class WorkTypeModel {
	private Long workTypeCode;
	private String workTypeName;
	private String status;
	private String description;
	public Long getWorkTypeCode() {
		return workTypeCode;
	}
	public void setWorkTypeCode(Long workTypeCode) {
		this.workTypeCode = workTypeCode;
	}
	public String getWorkTypeName() {
		return workTypeName;
	}
	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
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
