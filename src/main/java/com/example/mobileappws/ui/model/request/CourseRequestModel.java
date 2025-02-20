package com.example.mobileappws.ui.model.request;

import java.util.Collection;

import com.example.mobileappws.ui.model.response.UserRest;

public class CourseRequestModel {

	private String courseName;
	private int aktsCredit;
	private int section;
	private Collection<UserRequestModel> users;
	
	
	public CourseRequestModel() {
		// TODO Auto-generated constructor stub
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


	public Collection<UserRequestModel> getUsers() {
		return users;
	}


	public void setUsers(Collection<UserRequestModel> users) {
		this.users = users;
	}



	
	
}
