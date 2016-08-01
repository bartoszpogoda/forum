package com.bartoszpogoda.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bartoszpogoda.forum.service.TopicService;

@RequestMapping("/topics")
@Controller
public class TopicsController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping
	public String topics(Model model){
		model.addAttribute("topics", topicService.findAllTopic());
		return "topics";
	}
}
