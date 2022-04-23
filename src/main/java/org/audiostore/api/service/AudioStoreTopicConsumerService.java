package org.audiostore.api.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
public interface AudioStoreTopicConsumerService {
	
	public void consume(ConsumerRecord<String, String> payload);

}
