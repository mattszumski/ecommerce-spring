package com.ms.ecommerce.eshop.business.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CartImpl implements Cart{
	private List<CartItemDTO> cartItems;
	
	public CartImpl() {
		cartItems = new ArrayList<>();
	}
	
	@Override
	public Integer size() {
		return cartItems.size();
	}
	
	@Override
	public void addItem(CartItemDTO item) {
		if(cartItems.contains(item)) {
			int itemIndex = cartItems.indexOf(item);
			CartItemDTO itemAlreadyInCart = cartItems.get(itemIndex);
			Integer amountInCart = itemAlreadyInCart.getAmount();
			Integer additionalAmount = item.getAmount();
			itemAlreadyInCart.setAmount(amountInCart + additionalAmount);
		} else {
			cartItems.add(item);
		}
	}
	
	@Override
	public void removeItem(CartItemDTO item) {
		cartItems.remove(item);
	}

	public List<CartItemDTO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDTO> cartItems) {
		this.cartItems = cartItems;
	}
}
