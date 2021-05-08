package com.lti.am.model;

public class UserMessageModel {
	private Long id;
	private Long toUserID;
	private Long fromUserID;
	private String message;
	private String senderUserName;
	private String receiverUserName;
	private String messageDate;
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
	public String getSenderUserName() {
		return senderUserName;
	}
	public void setSenderUserName(String senderUserName) {
		this.senderUserName = senderUserName;
	}
	public String getReceiverUserName() {
		return receiverUserName;
	}
	public void setReceiverUserName(String receiverUserName) {
		this.receiverUserName = receiverUserName;
	}
	public String getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	
	
	
}
