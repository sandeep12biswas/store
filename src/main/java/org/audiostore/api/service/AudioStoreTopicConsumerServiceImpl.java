package org.audiostore.api.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.audiostore.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class AudioStoreTopicConsumerServiceImpl implements AudioStoreTopicConsumerService {
	
	@Autowired
	private UserService userService;
	private User userEntiry = null;
	
	
	
	 @Value("${topic.name.consumer}")
	    private String topicName;

	    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")

	public void consume(ConsumerRecord<String, String> payload) {
		System.out.println("topic name = "+topicName);
		System.out.println("key: {}"+ payload.key());
		System.out.println("Headers: {}"+ payload.headers());
		System.out.println("Partion: {}"+ payload.partition());
		System.out.println("Order: {}"+ payload.value());
		
		Gson gson = new Gson();
		userEntiry = gson.fromJson(payload.value(), User.class);
		
		userService.addUser(userEntiry);
		
	}

}
