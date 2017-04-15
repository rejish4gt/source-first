package com.deccanherald.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="source_first_codes")
public class SourceFirstCode {
	
	@Column(name="classification")
	private long classification;
	
	@Column(name="description")
	private String description;
	
	@Id
	@Column(name="code_value")
	private long value;
	
	@Column(name="code_name")
	private String name;

	public long getClassification() {
		return classification;
	}

	public void setClassification(long classification) {
		this.classification = classification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
