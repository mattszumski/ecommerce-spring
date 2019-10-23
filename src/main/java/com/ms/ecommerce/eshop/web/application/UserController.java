package com.ms.ecommerce.eshop.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.ecommerce.eshop.security.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/users/{username}", method=RequestMethod.GET)
	public String getUserWithUsername(@PathVariable("username") String username, Model model) {
		model.addAttribute("user", userRepository.findByUsername(username));
		return "getUser";
	}
	
	
}
