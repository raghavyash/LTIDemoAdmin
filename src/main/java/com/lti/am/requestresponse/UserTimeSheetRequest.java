package com.lti.am.requestresponse;

public class UserTimeSheetRequest {
	private Long userId;
	private Integer hours;
	private Long workItemCode;
	private String timesheetDate;
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
	
	
}
