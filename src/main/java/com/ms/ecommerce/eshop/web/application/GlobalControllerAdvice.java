package com.ms.ecommerce.eshop.web.application;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ms.ecommerce.eshop.business.service.CartService;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	@Autowired
	private CartService cartService;
	
	@ModelAttribute
	public void addCartToSession(HttpSession session) {
		session.setAttribute("cart", cartService);
	}
	

}
