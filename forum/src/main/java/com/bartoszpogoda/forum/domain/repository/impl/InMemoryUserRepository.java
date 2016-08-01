package com.bartoszpogoda.forum.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bartoszpogoda.forum.domain.User;
import com.bartoszpogoda.forum.domain.repository.UserRepository;

@Repository
public class InMemoryUserRepository implements UserRepository {
	List<User> listOfUser = new ArrayList<User>();

	public InMemoryUserRepository() {
		User fakeUserA = new User();
		fakeUserA.setNickname("mietek123");
		fakeUserA.setUsername("mietek");
		fakeUserA.setPassword("haslo");
		
		User fakeUserB = new User();
		fakeUserB.setNickname("heniek");
		fakeUserB.setUsername("heniek");
		fakeUserB.setPassword("haslo");

		listOfUser.add(fakeUserA);
		listOfUser.add(fakeUserB);
	}

	public User getUserByUsername(String username) {
		User userByUsername = null;
		for (User user : listOfUser) {
			if (user != null && user.getUsername() != null && user.getUsername().equalsIgnoreCase(username)) {
				userByUsername = user;
				break;
			}
		}
		return userByUsername;
	}

	public void addUser(User user) {
		listOfUser.add(user);
	}

	public User getUserByNickname(String nickname) {
		User userByNickname = null;

		for (User user : listOfUser) {
			if (user != null && user.getNickname() != null && user.getNickname().equalsIgnoreCase(nickname)) {
				userByNickname = user;
				break;
			}
		}
		return userByNickname;
	}
}
