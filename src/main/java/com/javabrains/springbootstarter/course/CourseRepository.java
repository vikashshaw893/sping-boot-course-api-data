package com.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer > {

	/*
	 * defining custom method without body with convention findBy___ 
	 * spring boot jpa automatic work on these methods example findByName
	 * some pre-define methos are FindById, FindAll etc
	 */
	
	public List<Course> findByName(String name);
	
	public List<Course> findByDescription(String description);
		
	public List<Course> findByTopicId(int topicId);
	
}
