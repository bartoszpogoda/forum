package com.bartoszpogoda.forum.domain.repository;

import java.util.List;

import com.bartoszpogoda.forum.domain.User;

public interface UserRepository {

	public User getUserByUsername(String username);

	public void addUser(User user);

	public User getUserByNickname(String nickname);

}
