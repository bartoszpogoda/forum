package com.bartoszpogoda.forum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bartoszpogoda.forum.service.PostService;
import com.bartoszpogoda.forum.service.TopicService;

@RequestMapping("/topics")
@Controller
public class TopicsController {

	@Autowired
	private TopicService topicService;
	@Autowired
	private PostService postService;

	@RequestMapping
	public String topics(Model model) {
		model.addAttribute("topics", topicService.findAllTopic());
		return "topics";
	}

	@RequestMapping("/topic/{id}")
	public String specificTopic(Model model, @PathVariable String id) {

		model.addAttribute("posts", postService.findAllPostsByTopicId(Integer.parseInt(id)));
		model.addAttribute("topic", topicService.findTopicById(Integer.parseInt(id)));
		return "topic";
	}

	@RequestMapping(value = "topic/{id}/post", method = RequestMethod.POST)
	public String post(@RequestParam String content, @PathVariable String id, HttpServletRequest req) {

		postService.createPost(Integer.parseInt(id), content,
				(String) req.getSession().getAttribute("loggedUserNickname"));

		return "forward:/topics/topic/" + id;
	}

}
