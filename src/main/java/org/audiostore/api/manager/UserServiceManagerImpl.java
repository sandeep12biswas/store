package org.audiostore.api.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.audiostore.api.entity.User;
import org.audiostore.api.exception.UserNotFoundException;
import org.audiostore.api.model.UserTO;
import org.audiostore.api.service.AudioStoreTopicProducerService;
import org.audiostore.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceManagerImpl implements UserServiceManager{
	
	private static final Logger logger = LogManager.getLogger(UserServiceManagerImpl.class);
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private AudioStoreTopicProducerService audioStoreTopicProducerService;
	
		
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@SuppressWarnings("unused")
	private User converttoEntity (UserTO userTo) {
		User userEntiry = modelMapper().map(userTo, User.class);
		
		return userEntiry;
		
	}
	
	@SuppressWarnings("unused")
	private UserTO converttoDTO (User user) {
		System.out.println("user="+user.toString());
		UserTO userTo  = modelMapper().map(user, UserTO.class);
		
		return userTo;
		
	}

	@Override
	public UserTO addUser(UserTO user) {
		
		User addedUser = userService.addUser(converttoEntity(user));
		return converttoDTO(addedUser);
	}

	@Override
	public Void deleteUser(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTO getUserById(Long Id) throws UserNotFoundException{
		 
		UserTO userTO =null;
		try {
			User user = userService.getUserById(Id);
			userTO = converttoDTO(user);
		} catch (Exception e) {
			logger.error("Failed to fetch user",e);
			throw new UserNotFoundException();
		}
		
		
		return userTO;
	}

	@Override
	public UserTO updateUser(UserTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUserToTopic(UserTO user) {
		String userMessage = null;
		try {
			userMessage = convertToString(user);
			audioStoreTopicProducerService.send(userMessage);
		} catch (Exception e) {
			logger.error("addUserToTopic: Failed to sent message into topic",e);
		}
		return userMessage;
		
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	private String convertToString (UserTO user) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString=null;
		 try {
			jsonString = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			logger.error("convertToString: Failed to convert"+ e);
		}
		
		return jsonString;
	}
	

}
