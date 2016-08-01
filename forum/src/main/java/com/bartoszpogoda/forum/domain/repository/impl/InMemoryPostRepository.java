package com.bartoszpogoda.forum.domain.repository.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bartoszpogoda.forum.domain.Post;
import com.bartoszpogoda.forum.domain.User;
import com.bartoszpogoda.forum.domain.repository.PostRepository;

@Repository
public class InMemoryPostRepository implements PostRepository {

	private List<Post> listOfPosts = new ArrayList<Post>();

	public void addPost(Post post) {
		listOfPosts.add(post);
	}

	public List<Post> findPostsByTopicIdOrdered(int topicId) {
		
		List<Post> allPosts = new ArrayList<Post>();
		
		for(Post post : listOfPosts){
			if(post != null && post.getTopicId() == topicId){
				allPosts.add(post);
			}
		}
		
		allPosts.sort(new Comparator<Post>(){
			public int compare(Post o1, Post o2) {
				return o1.getPostNumber() - o2.getPostNumber();
			}
		});

		return allPosts;
	}
	
	

}
