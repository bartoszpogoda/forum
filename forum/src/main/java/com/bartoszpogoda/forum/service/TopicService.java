package com.bartoszpogoda.forum.service;

import java.util.List;

import com.bartoszpogoda.forum.domain.Topic;

public interface TopicService {
	public List<Topic> findAllTopic();

	public Topic findTopicById(int topicId);
}
