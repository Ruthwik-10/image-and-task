package com.springbootdemo.crudExample.entity;

//import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

//import javax.persistence.Table;



@Data
@Entity
public class Task {

	@Id
	private int taskId;
	private String taskName;
	private String taskDescription;

	@ManyToOne
	@JoinColumn(name="profileId")
	private Profile profile;
	public Task()
	{
		
	}
		
	
	public Task(int taskId, String taskName, String taskDescription, Profile profile) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.profile = profile;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	

	  @Override
	  public String toString() {
	    return "Tutorial [id=" + taskId + ", task=" + taskName + ", desc=" + taskDescription +  "]";
	  }
	
	
	
	
}
