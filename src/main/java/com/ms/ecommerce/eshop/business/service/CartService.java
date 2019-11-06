package com.ms.ecommerce.eshop.business.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.ecommerce.eshop.business.domain.Cart;
import com.ms.ecommerce.eshop.business.domain.CartItemDTO;

@Service
public class CartService {

	@Autowired
	private Cart cart;
	
	public CartService() {
	}
	
	public void addItem(CartItemDTO cartItem) {
		cart.addItem(cartItem);
	}
	
	public List<CartItemDTO> getCartData() {
		return cart.getCartItems();
	}
	public Integer getNumberOfItemsInCart() {
		return cart.size();
	}
	
	public BigDecimal getCartTotal() {
		BigDecimal total = new BigDecimal(0);
		for(CartItemDTO item : cart.getCartItems()) {
			BigDecimal amount = new BigDecimal(item.getAmount());
			BigDecimal subtotalForItem = amount.multiply(item.getPrice());
			total = total.add(subtotalForItem);
		}
		return total;
	}
}
