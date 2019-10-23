package com.ms.ecommerce.eshop.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.ms.ecommerce.eshop.security.domain.EShopUserDetails;
import com.ms.ecommerce.eshop.security.entity.User;
import com.ms.ecommerce.eshop.security.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly =true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User with username " + username + " not found.");
		}
		
		return new EShopUserDetails(user);
	}

}
