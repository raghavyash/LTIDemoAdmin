package com.lti.am.requestresponse;


public class UserMessageRequest {
	private Long id;
	private Long toUserID;
	private Long fromUserID;
	private String message;
	private String messageDate;
	
	public String getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getToUserID() {
		return toUserID;
	}
	public void setToUserID(Long toUserID) {
		this.toUserID = toUserID;
	}
	public Long getFromUserID() {
		return fromUserID;
	}
	public void setFromUserID(Long fromUserID) {
		this.fromUserID = fromUserID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
