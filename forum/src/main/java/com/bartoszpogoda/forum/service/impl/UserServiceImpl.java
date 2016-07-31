package com.bartoszpogoda.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bartoszpogoda.forum.domain.User;
import com.bartoszpogoda.forum.domain.repository.UserRepository;
import com.bartoszpogoda.forum.exception.UserNotFoundException;
import com.bartoszpogoda.forum.exception.WrongPasswordException;
import com.bartoszpogoda.forum.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * @return user who logged in, or null if wrong username or password
	 */
	public User processLogIn(String username, String password) {
		User loogedUser = null;

		User userByUsername = userRepository.getUserByUsername(username);

		if (userByUsername == null)
			throw new UserNotFoundException();

		if (!userByUsername.getPassword().equals(password))
			throw new WrongPasswordException();

		loogedUser = userByUsername;

		return loogedUser;
	}

	public User getUserByNickname(String nickname) {
		return userRepository.getUserByNickname(nickname);
	}

	public boolean processLogOut(String nickname) {
		User loggedUser = userRepository.getUserByNickname(nickname);

		if (loggedUser == null)
			throw new UserNotFoundException();

		return true;
	}

}
