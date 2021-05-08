package com.lti.am.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_work_item")
public class UserWorkItemEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	public UserWorkItemEntity(){}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	@GenericGenerator(name = "seq", strategy="increment")
	@Column(name="USER_WORK_ITEM_ID")
	private Long userWorkItemId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private CustomerEntity userId;
	
	@OneToMany
	@JoinTable(
            name="ASSIGN_USER_WI",
            joinColumns = @JoinColumn( name="USER_WORK_ITEM_ID"),
            inverseJoinColumns = @JoinColumn( name="WORK_ITEM_CODE")
    )private Set<WorkItemEntity> workItemEntities= new HashSet<WorkItemEntity>();
	
    @Column(name="MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	
	
	
	
	
	public Long getUserWorkItemId() {
		return userWorkItemId;
	}
	public void setUserWorkItemId(Long userWorkItemId) {
		this.userWorkItemId = userWorkItemId;
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
	public CustomerEntity getUserId() {
		return userId;
	}
	public void setUserId(CustomerEntity userId) {
		this.userId = userId;
	}
	public Set<WorkItemEntity> getWorkItemEntities() {
		return workItemEntities;
	}
	public void setWorkItemEntities(Set<WorkItemEntity> workItemEntities) {
		this.workItemEntities = workItemEntities;
	}
	
}
