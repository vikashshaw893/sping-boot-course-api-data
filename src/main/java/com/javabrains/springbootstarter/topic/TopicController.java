package com.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	/*
	 * Autowiring feature of spring framework enables you to inject the object dependency implicitly. 
	 * It internally uses setter or constructor injection. 
	 * Autowiring can't be used to inject primitive and string values. 
	 * It works with reference only.
	 */
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("")
	public String notFound() {
		return "Wrong Path!";
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	/* here id will be accessed from request URL
	 * keeping {id} same like method parameter  
	 */
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable int id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topic")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable int id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{id}")
	public void deleteTopic(@PathVariable int id) {
		topicService.deleteTopic(id);
	}
	
}
