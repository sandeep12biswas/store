package org.audiostore.api.service;

import org.springframework.stereotype.Service;

@Service
public interface AudioStoreTopicProducerService {
	
	public void send(String message);
	 
	
}
