package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sms_strategy")
@EntityListeners(AuditingEntityListener.class)
public class Strategy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Strategy_ID")
	private long id;

//	@Column(name = "Organization_ID")
//	private long organizationId;

	// @JsonIgnoreProperties("questions")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Organization_ID")
	private Organisation organisation;

	@Column(name = "Strategy_Name_Eng")
	private String strNameEng;

	@Column(name = "Strategy_Name_Ar")
	private String strNameAr;

	@Column(name = "image")
	private String image;

	@Column(name = "Creation_User")
	private long user;

	@Column(name = "Record_status")
	private long recordStatus;

	@Column(name = "Creation_date",nullable = false, updatable = false)
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

//	public long getOrganizationId() {
//		return organizationId;
//	}
//
//	public void setOrganizationId(long organizationId) {
//		this.organizationId = organizationId;
//	}

	public String getStrNameEng() {
		return strNameEng;
	}

	public void setStrNameEng(String strNameEng) {
		this.strNameEng = strNameEng;
	}

	public String getStrNameAr() {
		return strNameAr;
	}

	public void setStrNameAr(String strNameAr) {
		this.strNameAr = strNameAr;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
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
