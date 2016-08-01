package com.bartoszpogoda.forum.domain.repository.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.stereotype.Repository;

import com.bartoszpogoda.forum.domain.Post;
import com.bartoszpogoda.forum.domain.Topic;
import com.bartoszpogoda.forum.domain.User;
import com.bartoszpogoda.forum.domain.repository.PostRepository;

@Repository
public class InMemoryPostRepository implements PostRepository {

	private List<Post> listOfPosts = new ArrayList<Post>();

	public InMemoryPostRepository() {
		Post post1 = new Post(1);
		post1.setPostNumber(0);
		post1.setAuthor("mietek");
		post1.setContent("Czeœæ forumowicze, szukam ¿ony");

		Post post2 = new Post(1);
		post2.setPostNumber(1);
		post2.setAuthor("snipiasty");
		post2.setContent("Tutaj jej nie znajdziesz");

		Post post3 = new Post(2);
		post3.setPostNumber(0);
		post3.setAuthor("snipiasty");
		post3.setContent("Jak w temacie, sprzedam opla");

		listOfPosts.add(post1);
		listOfPosts.add(post2);
		listOfPosts.add(post3);

	}

	public void addPost(Post post) {
		listOfPosts.add(post);
	}

	public List<Post> findPostsByTopicIdOrdered(int topicId) {

		List<Post> allPosts = new ArrayList<Post>();

		for (Post post : listOfPosts) {
			if (post != null && post.getTopicId() == topicId) {
				allPosts.add(post);
			}
		}

		allPosts.sort(new Comparator<Post>() {
			public int compare(Post o1, Post o2) {
				return o1.getPostNumber() - o2.getPostNumber();
			}
		});

		return allPosts;
	}

}
