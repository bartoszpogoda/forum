package com.bartoszpogoda.forum.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bartoszpogoda.forum.domain.Topic;
import com.bartoszpogoda.forum.domain.repository.TopicRepository;

@Repository
public class InMemoryTopicRepository implements TopicRepository {

	private List<Topic> listOfTopics = new ArrayList<Topic>();
	
	public InMemoryTopicRepository(){
		Topic topic1 = new Topic(1);
		topic1.setTitle("Szukam ¿ony");
		topic1.setAuthorNickname("mietek");
		
		Topic topic2 = new Topic(2);
		topic2.setTitle("Sprzedam opla");
		topic2.setAuthorNickname("snipiasty");
		
		listOfTopics.add(topic1);
		listOfTopics.add(topic2);
	}
	
	public List<Topic> findAllTopics() {
		return listOfTopics;
	}

	public Topic findTopicById(int topicId) {
		Topic topicById = null;
		
		for(Topic topic : listOfTopics){
			if(topic != null && topic.getTopicId() == topicId){
				topicById = topic;
				break;
			}
		}
		
		return topicById;
	}

}
