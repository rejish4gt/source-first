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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@OneToOne
	@JoinColumn(name="issue_report_id")
	private IssueReport issueReport;
	
	@OneToOne
	@JoinColumn(name="category_id")
	private SourceFirstCode category;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content", columnDefinition="text")
	private String content;
	
	@Column(name="article_by")
	private String articleBy;
	
	@Column(name="image_name")
	private String imageName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createdDate;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public IssueReport getIssueReport() {
		return issueReport;
	}

	public void setIssueReport(IssueReport issueReport) {
		this.issueReport = issueReport;
	}

	public SourceFirstCode getCategory() {
		return category;
	}

	public void setCategory(SourceFirstCode category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleBy() {
		return articleBy;
	}

	public void setArticleBy(String articleBy) {
		this.articleBy = articleBy;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
