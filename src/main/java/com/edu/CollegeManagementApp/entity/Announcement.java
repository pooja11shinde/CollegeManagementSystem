package com.edu.CollegeManagementApp.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Announcement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private long id;

	@Column
	private String topic;
	@Column
	private String description;
	
	//@Column(updatable=false)
	@Temporal(TemporalType.DATE)
	private  Date ann_date;
	
	@PrePersist
	private void onCreate() {
		ann_date = new Date();
	}
	
	public Announcement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Announcement(long id, String topic, String description, Date ann_date) {
		super();
		this.id = id;
		this.topic = topic;
		this.description = description;
		this.ann_date = ann_date;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAnn_date() {
		return ann_date;
	}

	public void setAnn_date(Date ann_date) {
		this.ann_date = ann_date;
	}


	@Override
	public String toString() {
		return "Announcement [id=" + id + ", topic=" + topic + ", description=" + description + ", ann_date=" + ann_date
				+ "]";
	}

	

}
