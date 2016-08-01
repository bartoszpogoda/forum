package com.bartoszpogoda.forum.domain.repository;

import java.util.List;

import com.bartoszpogoda.forum.domain.Post;

public interface PostRepository {
	public void addPost(Post post);
	
	public List<Post> findPostsByTopicIdOrdered(int topicId);
}
