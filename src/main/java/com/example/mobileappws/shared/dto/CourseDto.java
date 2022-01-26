package com.example.mobileappws.shared.dto;

import java.io.Serializable;
import java.util.Collection;



import com.example.mobileappws.io.entity.UserEntity;

public class CourseDto implements Serializable{
	
	private static final long serialVersionUID = -2484269131158466865L;
	private long id;
	private String courseId;
	private String courseName;
	private int aktsCredit;
	private int section;
	private Collection<UserDto> users;
	
	
	public CourseDto() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getAktsCredit() {
		return aktsCredit;
	}

	public void setAktsCredit(int aktsCredit) {
		this.aktsCredit = aktsCredit;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public Collection<UserDto> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDto> users) {
		this.users = users;
	}



}
