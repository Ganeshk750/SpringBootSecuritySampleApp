package com.ganesh.service;

import com.ganesh.model.User;

public interface UserService {
	
	 public User save(User user);
	 public User updateUser(long id, User user);

}
