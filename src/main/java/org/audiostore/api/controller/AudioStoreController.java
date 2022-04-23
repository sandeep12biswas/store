package org.audiostore.api.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.audiostore.api.manager.UserServiceManager;
import org.audiostore.api.model.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api") 
public class AudioStoreController {
	
	private static final Logger logger = LogManager.getLogger(AudioStoreController.class);
	
	@Autowired
	private UserServiceManager userManager;
	
	
	public UserServiceManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserServiceManager userManager) {
		this.userManager = userManager;
	}

	@RequestMapping (method = RequestMethod.GET, value="/getuser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserTO> getApiName (@PathVariable Long id){
		
		if (logger.isDebugEnabled()) {
            logger.debug("Hello from Log4j 2 - num : {}", id);
        }
		
		UserTO user = userManager.getUserById(id);
		return new ResponseEntity<> (user, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "createuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    	public ResponseEntity<String> createUser (@RequestBody UserTO user){
		if (logger.isDebugEnabled()) {
            logger.debug("User =", user.toString());
        }
		String userString = userManager.addUserToTopic(user);
		
		if (null != userString) {
			return new ResponseEntity<>("User Created", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
