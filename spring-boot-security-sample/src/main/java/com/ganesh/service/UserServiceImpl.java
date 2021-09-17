package com.ganesh.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ganesh.model.User;
import com.ganesh.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	  private final UserRepository userRepository;

	  private final PasswordEncoder passwordEncoder;

	@Override
	public User save(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		return this.userRepository.save(user);
	}

	@Override
	public User updateUser(long id, User user) {

		//User inDB = userRepository.getOne(id);
		User inDB = userRepository.findById(id).get();
		inDB.setDisplayName(user.getDisplayName());
		inDB.setLastUpdated(LocalDateTime.now());
		return userRepository.save(inDB);
	}

      

}
