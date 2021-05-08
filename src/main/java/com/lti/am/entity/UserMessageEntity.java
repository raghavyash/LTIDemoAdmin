package com.lti.am.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_message")
public class UserMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserMessageEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	@GenericGenerator(name = "seq", strategy="increment")
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TO_USER_ID")
	private CustomerEntity toUserEntityID;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "FROM_USER_ID")
	private CustomerEntity fromUserEntityID;

	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "MESSAGE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date messageDate;

	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public String getMessage() {
		return message;
	}
	public CustomerEntity getToUserEntityID() {
		return toUserEntityID;
	}
	public void setToUserEntityID(CustomerEntity toUserEntityID) {
		this.toUserEntityID = toUserEntityID;
	}
	public CustomerEntity getFromUserEntityID() {
		return fromUserEntityID;
	}
	public void setFromUserEntityID(CustomerEntity fromUserEntityID) {
		this.fromUserEntityID = fromUserEntityID;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
