package org.audiostore.api.manager;

import org.audiostore.api.exception.UserNotFoundException;
import org.audiostore.api.model.UserTO;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceManager {
	public UserTO addUser (UserTO user) ;
	
	public Void deleteUser(Long Id);
	
	public UserTO getUserById (Long Id) throws UserNotFoundException;
	
	public UserTO updateUser (UserTO user);
	
	public String addUserToTopic (UserTO user);

}
