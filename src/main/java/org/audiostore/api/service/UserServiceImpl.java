package org.audiostore.api.service;

import org.audiostore.api.entity.User;
import org.audiostore.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		User createdUser = userRepository.save(user);
		return createdUser;
	}

	@Override
	public Void deleteUser(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Long Id) {
		return  userRepository.getById(Id);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
