package com.bartoszpogoda.forum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bartoszpogoda.forum.domain.User;
import com.bartoszpogoda.forum.exception.UserNotFoundException;
import com.bartoszpogoda.forum.exception.WrongPasswordException;
import com.bartoszpogoda.forum.service.UserService;

@RequestMapping
@Controller
public class LogController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest req) {
		User loggedUser = userService.processLogIn(username, password);

		req.getSession().setAttribute("loggedUserNickname", (String) loggedUser.getNickname());

		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String processLogout(HttpServletRequest req, Model model) {

		if (req.getSession().getAttribute("loggedUserNickname") == null
				|| (String) (req.getSession().getAttribute("loggedUserNickname")) == "")
			return "login";

		if (userService.processLogOut((String) req.getSession().getAttribute("loggedUserNickname"))) {
			req.getSession().setAttribute("loggedUserNickname", "");
			req.setAttribute("info", "You have succesfully logged out");
			return "forward:/";
		}

		return "login";
	}

	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException(HttpServletRequest req) {
		req.setAttribute("error", "User with that username doesn't exist");

		return "login";
	}

	@ExceptionHandler(WrongPasswordException.class)
	public String handleWrongPasswordException(HttpServletRequest req) {
		req.setAttribute("error", "Wrong password");

		return "login";
	}
}
