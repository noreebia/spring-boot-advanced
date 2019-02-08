package com.sooyoung.springbootadvanced.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sooyoung.springbootadvanced.domain.entity.User;
import com.sooyoung.springbootadvanced.domain.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUsername(username).orElseThrow(() -> {return new UsernameNotFoundException("Username not found")});
		Optional<User> userOptional = userRepository.findByUsername(username);
		if(userOptional.isPresent()) {
			System.out.println("You have NOT fucked up! welcome in");
			User user = userOptional.get();
			return new org.springframework.security.core.userdetails.User(username, user.getUserPassword(), new ArrayList<>());

		} else {
			System.out.println("You have fucked up!!");
			throw new UsernameNotFoundException("You have fucked up!");
		}
		
	}

}
