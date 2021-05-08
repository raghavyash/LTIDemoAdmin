package com.lti.am.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_timesheet")
public class UserTimeSheetEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	public UserTimeSheetEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	@GenericGenerator(name = "seq", strategy="increment")
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private CustomerEntity userEntityID;

	
	@Column(name = "TIMESHEET_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeSheetDate;
	
	@Column(name = "HOURS")
	private Integer hours;
	
	@ManyToOne
	@JoinColumn(name="WORK_ITEM_CODE")
	private WorkItemEntity workItemEntities;
	
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public CustomerEntity getUserEntityID() {
		return userEntityID;
	}
	public void setUserEntityID(CustomerEntity userEntityID) {
		this.userEntityID = userEntityID;
	}
	public Date getTimeSheetDate() {
		return timeSheetDate;
	}
	public void setTimeSheetDate(Date timeSheetDate) {
		this.timeSheetDate = timeSheetDate;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	public WorkItemEntity getWorkItemEntities() {
		return workItemEntities;
	}
	public void setWorkItemEntities(WorkItemEntity workItemEntities) {
		this.workItemEntities = workItemEntities;
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
