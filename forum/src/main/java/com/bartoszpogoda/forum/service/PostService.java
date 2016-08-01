package com.bartoszpogoda.forum.service;

import java.util.List;

import com.bartoszpogoda.forum.domain.Post;

public interface PostService {
	public List<Post> findAllPostsByTopicId(int topicId);
	public void createPost(int topicId, String content, String author);
}
