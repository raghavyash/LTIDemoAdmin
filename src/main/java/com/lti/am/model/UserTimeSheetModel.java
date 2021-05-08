package com.lti.am.model;

public class UserTimeSheetModel {
	private Long userId;
	private Integer hours;
	private Long workItemCode;
	private String timesheetDate;
	private String workItemName;
	private String userName;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public Long getWorkItemCode() {
		return workItemCode;
	}
	public void setWorkItemCode(Long workItemCode) {
		this.workItemCode = workItemCode;
	}
	public String getTimesheetDate() {
		return timesheetDate;
	}
	public void setTimesheetDate(String timesheetDate) {
		this.timesheetDate = timesheetDate;
	}
	public String getWorkItemName() {
		return workItemName;
	}
	public void setWorkItemName(String workItemName) {
		this.workItemName = workItemName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
