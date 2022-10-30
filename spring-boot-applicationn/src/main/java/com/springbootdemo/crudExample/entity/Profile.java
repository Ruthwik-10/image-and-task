package com.springbootdemo.crudExample.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.Lob;

import lombok.Data;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//



@Data
@Entity
//@Table(name = "PROFILES_TBL")
public class Profile {
	
    @Id
    @GeneratedValue
    private int profileId;
    private String name;
//    private String fileName;
//    private String message;
//    private String role;y=
//    @OneToMany(targetEntity=Task.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="pt_fk",referencedColumnName = "profileId")
//    private List<Task> tasks;
    @Lob
    private byte[] image;
    
    
    
    
    public Profile(int profileId, String name) {
    	super();
    	this.profileId = profileId;
    	this.name = name;
    }
     
//	public Profile(String fileName, String message) {
//	super();
//	this.fileName = fileName;
//	this.message = message;
//}
//	
	

//	public Profile(int profileId, String name, String fileName, String message) {
//		super();
//		this.profileId = profileId;
//		this.name = name;
//		this.fileName = fileName;
//		this.message = message;
//	}

	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Profile(int profileId, String name, byte[] image) {
	super();
	this.profileId = profileId;
	this.name = name;
	this.image = image;
}

	public int getProfileId() {
    	return profileId;
    }
	public void setProfileId(int profileId) {
    	this.profileId = profileId;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	

//	public String getFileName() {
//		return fileName;
//	}
//
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	
	
	
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
}
