package com.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("A1", "Spring MVC", "this is a Spring MVC desc"),
			new Topic("A2", "SpringBoot", "this is a SpringBoot App"), new Topic("A3", "Java", "this is a Java App"),
			new Topic("A4", "mule", "this is a mule App"), new Topic("A5", "mulesoft", "this is a mulesoft App")));

	public List<Topic> getAllTopic() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));

	}

}
