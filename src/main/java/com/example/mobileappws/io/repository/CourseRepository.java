package com.example.mobileappws.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.mobileappws.io.entity.CourseEntity;

public interface CourseRepository extends CrudRepository<CourseEntity, Long> {

	CourseEntity findByCourseName(String courseName);
	
	@Query(value="select c.* from Courses c inner join users_courses uc on c.id=uc.course_id where uc.user_id=:userId",nativeQuery = true)
	List<CourseEntity> getCoursesByUserId(@Param("userId")Long userId);
	
	
}
