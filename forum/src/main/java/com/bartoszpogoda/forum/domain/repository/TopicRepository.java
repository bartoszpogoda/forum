package com.bartoszpogoda.forum.domain.repository;

import java.util.List;

import com.bartoszpogoda.forum.domain.Topic;

public interface TopicRepository {
	public List<Topic> findAllTopics();
	
	public Topic findTopicById(int topicId);
}
