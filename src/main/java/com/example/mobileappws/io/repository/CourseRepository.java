package com.example.mobileappws.io.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.mobileappws.io.entity.CourseEntity;

public interface CourseRepository extends CrudRepository<CourseEntity, Long> {

	CourseEntity findByCourseName(String courseName);
}
