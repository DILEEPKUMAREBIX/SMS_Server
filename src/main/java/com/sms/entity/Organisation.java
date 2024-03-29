package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sms_organization")
@EntityListeners(AuditingEntityListener.class)
public class Organisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Organization_ID")
	private long id;

	@Column(name = "Organization_Name_Eng")
	private String orgNameEng;

	@Column(name = "Organization_Name_Ar")
	private String orgNameAr;

	@Column(name = "Creation_User")
	private Long user;

	@Column(name = "Record_status")
	private long recordStatus;

	@Column(name = "Creation_date", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MMM-YYYY")
	@CreatedDate
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MMM-YYYY")
	@LastModifiedDate
	@Column(name = "Update_date", nullable = false)
	private Date updateDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrgNameEng() {
		return orgNameEng;
	}

	public void setOrgNameEng(String orgNameEng) {
		this.orgNameEng = orgNameEng;
	}

	public String getOrgNameAr() {
		return orgNameAr;
	}

	public void setOrgNameAr(String orgNameAr) {
		this.orgNameAr = orgNameAr;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public long getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(long recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
