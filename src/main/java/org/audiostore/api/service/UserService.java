package org.audiostore.api.service;

import org.audiostore.api.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	public User addUser (User user) ;
	
	public Void deleteUser(Long Id);
	
	public User getUserById (Long Id);
	
	public User updateUser (User user);

}
