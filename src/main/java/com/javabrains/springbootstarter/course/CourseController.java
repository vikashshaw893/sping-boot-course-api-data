package com.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	/*
	 * Autowiring feature of spring framework enables you to inject the object dependency implicitly. 
	 * It internally uses setter or constructor injection. 
	 * Autowiring can't be used to inject primitive and string values. 
	 * It works with reference only.
	 */
	@Autowired
	private CourseService courseService;
		
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllTopics(@PathVariable int topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	/* here id will be accessed from request URL
	 * keeping {id} same like method parameter  
	 * only passing courseId in parameter
	 */
	@RequestMapping("/topic/{topicId}/course/{courseId}")
	public Course getTopic(@PathVariable int courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topic/{topicId}/course")
	public void addTopic(@RequestBody Course course, @PathVariable int topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{topicId}/course/{courseId}")
	public void updateTopic(@RequestBody Course course, @PathVariable int topicId, @PathVariable int courseId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(courseId, course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{topicId}/course/{courseId}")
	public void deleteTopic(@PathVariable int courseId) {
		courseService.deleteCourse(courseId);
	}
	
}
