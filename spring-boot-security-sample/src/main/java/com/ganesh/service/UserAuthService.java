package com.ganesh.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ganesh.configuration.AppUser;
import com.ganesh.model.User;
import com.ganesh.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User inDB = userRepository.findByUsername(username);
		if (inDB == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new AppUser(inDB);
	}

}
