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
		Topic topicA = new Topic(1);
		topicA.setTitle("Temat pierwszy");
		topicA.setAuthorNickname("autor1");
		
		listOfTopics.add(topicA);
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
