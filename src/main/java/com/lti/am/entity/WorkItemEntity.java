package com.lti.am.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="work_item")
public class WorkItemEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	public WorkItemEntity(){}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	@GenericGenerator(name = "seq", strategy="increment")
    @Column(name="WORK_ITEM_CODE")
	private Long workItemCode;
    @Column(name="WORK_ITEM_NAME")
	private String workItemName;
    @ManyToOne
    @JoinColumn(name="WORK_TYPE_CODE")
    private WorkTypeEntity workTypeEntity;
    @Column(name="STATUS")
    private String status;
    @Column(name="Description")
    private String description;
    @Column(name="MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
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
	public WorkTypeEntity getWorkTypeEntity() {
		return workTypeEntity;
	}
	public void setWorkTypeEntity(WorkTypeEntity workTypeEntity) {
		this.workTypeEntity = workTypeEntity;
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
