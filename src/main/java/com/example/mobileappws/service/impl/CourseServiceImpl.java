package com.example.mobileappws.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mobileappws.io.entity.CourseEntity;
import com.example.mobileappws.io.entity.RoleEntity;
import com.example.mobileappws.io.entity.UserEntity;
import com.example.mobileappws.io.repository.CourseRepository;
import com.example.mobileappws.io.repository.UserRepository;
import com.example.mobileappws.service.CourseService;
import com.example.mobileappws.shared.dto.AddressDTO;
import com.example.mobileappws.shared.dto.CourseDto;
import com.example.mobileappws.shared.dto.UserDto;
import com.example.mobileappws.shared.dto.Utils;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	Utils utils;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public CourseDto createCourse(CourseDto course) {
		
				if(courseRepository.findByCourseName(course.getCourseName())!=null)
					{
					throw new RuntimeException("Record already exists.");
					}
				
				
				
				ModelMapper modelMapper=new ModelMapper();
				
				
				Collection<UserDto> listofUsers=new ArrayList<>();
				for(UserDto user : course.getUsers()) {
					UserEntity userEnt=userRepository.findByUserId(user.getUserId());
					UserDto savedUserDto=modelMapper.map(userEnt, UserDto.class);
					listofUsers.add(savedUserDto);	
				}
				
				course.setUsers(listofUsers);
				
				
				
				
				CourseEntity courseEntity=modelMapper.map(course, CourseEntity.class);
				System.out.println("----------------------------------------------");
				
				
			
				
				
				
				
				String publicCourseId=utils.generateCourseId(30);
				courseEntity.setCourseId(publicCourseId);
				
				
				
				CourseEntity storedCourseDetails= courseRepository.save(courseEntity);
				
				CourseDto returnValue=modelMapper.map(storedCourseDetails, CourseDto.class);

				return returnValue;
	}

	@Override
	public CourseDto updateCourse(CourseDto course) {

		
		if(courseRepository.findByCourseName(course.getCourseName())==null)
		{
		throw new RuntimeException("Course not exists.");
		}
		CourseEntity courseDetails=courseRepository.findByCourseName(course.getCourseName());
		
		
		
		ModelMapper modelMapper=new ModelMapper();
		
		for(UserDto user : course.getUsers()) {
			UserEntity userEnt=userRepository.findByUserId(user.getUserId());
			
			if(!courseDetails.getUsers().contains(userEnt)) {
				courseDetails.getUsers().add(userEnt);
			}
			
		}
		
		
		CourseEntity updatedCourse=courseRepository.save(courseDetails);

		
		CourseDto returnValue=modelMapper.map(updatedCourse, CourseDto.class);

		return returnValue;
	}

	@Override
	public CourseDto deleteStudentFromCourse(CourseDto course, String studentId) {
		
		CourseEntity courseDetails=courseRepository.findByCourseName(course.getCourseName());
		UserEntity deletingUser=userRepository.findByUserId(studentId);
		if(courseDetails.getCourseName()==null)
		{
		throw new RuntimeException("Course not exists.");
		}
		if(!courseDetails.getUsers().contains(deletingUser)) {
			throw new RuntimeException("Student not exists in the course.");
		}
		ModelMapper modelMapper=new ModelMapper();
		
		courseDetails.getUsers().remove(deletingUser);
		
		CourseEntity updatedCourse=courseRepository.save(courseDetails);
		CourseDto returnValue=modelMapper.map(updatedCourse, CourseDto.class);
		
		return returnValue;
	}

	@Override
	public List<CourseDto> getMyCourses(String userId) {
		
		List<CourseDto> returnValue=new ArrayList<>();
		
		UserEntity userEntity=userRepository.findByUserId(userId);
		
		List<CourseEntity> courseEntities=courseRepository.getCoursesByUserId(userEntity.getId());
		
		
		ModelMapper modelMapper=new ModelMapper();
		
		for(CourseEntity courseEntity : courseEntities) {
			
			returnValue.add(modelMapper.map(courseEntity, CourseDto.class));
			
		}
		
		
		
		
		return returnValue;
	}

}
