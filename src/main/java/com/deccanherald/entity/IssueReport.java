package com.deccanherald.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="issue_reports")
public class IssueReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="category_id")
	private long categoryId;
	
	@Column(name="hashtags")
	private String hashtags;
	
	@Column(name="is_anonymous")
	private boolean isAnonymous;
	
	@Column(name="contact_name")
	private String contactName;
	
	@Column(name="contact_mobile")
	private String contactMobile;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createdDate;
	
	@OneToOne
	@JoinColumn(name="status")
	private SourceFirstCode status;
	
	@PrePersist
	protected void onCreate()
	{
		createdDate = new Date();
	}

	public String getHashtags() {
		return hashtags;
	}

	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isAnonymous() {
		return isAnonymous;
	}

	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		if(contactName!=null)
			setAnonymous(false);
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public SourceFirstCode getStatus() {
		return status;
	}

	public void setStatus(SourceFirstCode status) {
		this.status = status;
	}

}
