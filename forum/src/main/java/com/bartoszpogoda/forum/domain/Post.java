package com.bartoszpogoda.forum.domain;

public class Post {
	private int topicId;
	private int postNumber;
	private String author;
	private String content;

	public Post(int threadId) {
		this.topicId = threadId;
	}

	public Post() {

	}	

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postNumber;
		result = prime * result + topicId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (postNumber != other.postNumber)
			return false;
		if (topicId != other.topicId)
			return false;
		return true;
	}

	
}
