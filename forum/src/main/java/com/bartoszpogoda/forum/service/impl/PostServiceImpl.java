package com.bartoszpogoda.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bartoszpogoda.forum.domain.Post;
import com.bartoszpogoda.forum.domain.repository.PostRepository;
import com.bartoszpogoda.forum.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAllPostsByTopicId(int topicId) {
		return postRepository.findPostsByTopicIdOrdered(topicId);
	}

}
