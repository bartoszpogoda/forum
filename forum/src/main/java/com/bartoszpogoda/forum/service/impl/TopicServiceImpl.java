package com.bartoszpogoda.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bartoszpogoda.forum.domain.Topic;
import com.bartoszpogoda.forum.domain.repository.TopicRepository;
import com.bartoszpogoda.forum.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> findAllTopic() {
		return topicRepository.findAllTopics();
	}

}
