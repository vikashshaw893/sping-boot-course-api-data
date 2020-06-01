/* 
 * creating business service is typically a singleton
 */
package com.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Course> courses = new ArrayList<>(Arrays.asList(
//				new Course(1,"course1", "course1 descriotion"),
//				new Course(2,"course2", "course2 descriotion"),
//				new Course(3,"course3", "course3 descriotion"),
//				new Course(4,"course4", "course4 descriotion")
//				));

	public List<Course> getAllCourses(int topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses; 
	}
	
	
	public Course getCourse(int id) {
		//return topics.stream().filter(t -> t.getId() == id).findFirst().get();
		return courseRepository.findById(id).orElse(null);		
	}

	public void addCourse(Course course) {
		//topics.add(topic);
		courseRepository.save(course);
	}
	
	public void updateCourse(int id, Course course ) {
		/*for(int i = 0; i<courses.size(); i++ ) {
			Course t = courses.get(i);
			if(t.getId() == id) {
				courses.set(i, topic);
				return;
			}
		}*/	
		courseRepository.save(course);
	}

	public void deleteCourse(int id) {
		// courses.removeIf(t -> t.getId() == id);
		courseRepository.deleteById(id);
		
	}

}
