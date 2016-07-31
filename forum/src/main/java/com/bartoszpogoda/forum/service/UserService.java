package com.bartoszpogoda.forum.service;

import com.bartoszpogoda.forum.domain.User;

public interface UserService {
	public User processLogIn(String username, String password);
	
	public boolean processLogOut(String nickname);

	public User getUserByNickname(String nickname);
}
