package com.ms.ecommerce.eshop.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.ms.ecommerce.eshop.business.domain.Cart;
import com.ms.ecommerce.eshop.business.domain.CartItemDTO;

@Service
@SessionScope
public class CartService {

	@Autowired
	private Cart cart;
	
	public CartService() {
	}
	
	public void addItem(CartItemDTO cartItem) {
		cart.addItem(cartItem);
	}
	
	public String getCartData() {
		return "This is cart in session" ;
	}
	public Integer getNumberOfItemsInCart() {
		return cart.size();
	}
}
