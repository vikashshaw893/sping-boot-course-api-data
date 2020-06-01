/* 
 * creating business service is typically a singleton
 */
package com.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//				new Topic(1,"topic1", "topic1 descriotion"),
//				new Topic(2,"topic2", "topic2 descriotion"),
//				new Topic(3,"topic3", "topic3 descriotion"),
//				new Topic(4,"topic4", "topic4 descriotion")
//				));

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics; 
	}
	
	
	public Topic getTopic(int id) {
		//return topics.stream().filter(t -> t.getId() == id).findFirst().get();
		Topic topic = topicRepository.findById(id).orElse(null);
		if(topic == null) {
			throw new RuntimeException("topic id not found - "+id);
		}
		return topic;
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	public void updateTopic(int id, Topic topic ) {
		/*for(int i = 0; i<topics.size(); i++ ) {
			Course t = topics.get(i);
			if(t.getId() == id) {
				topics.set(i, topic);
				return;
			}
		}*/	
		topicRepository.save(topic);
	}

	public void deleteTopic(int id) {
		// topics.removeIf(t -> t.getId() == id);
		topicRepository.deleteById(id);
		
	}

}
