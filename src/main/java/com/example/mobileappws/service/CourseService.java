package com.example.mobileappws.service;

import com.example.mobileappws.shared.dto.CourseDto;

public interface CourseService {

	CourseDto createCourse(CourseDto course);
	CourseDto updateCourse(CourseDto course);
	
	
}
