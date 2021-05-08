package com.lti.am.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="work_type")
public class WorkTypeEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	public WorkTypeEntity(){}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	@GenericGenerator(name = "seq", strategy="increment")
    @Column(name="WORK_TYPE_CODE")
	private Long workTypeCode;
    @Column(name="WORK_TYPE_NAME")
	private String workTypeName;
    @Column(name="STATUS")
    private String status;
    @Column(name="Description")
    private String description;
    @Column(name="MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
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
	public Long getWorkTypeCode() {
		return workTypeCode;
	}
	public void setWorkTypeCode(Long workTypeCode) {
		this.workTypeCode = workTypeCode;
	}
	
	
}
