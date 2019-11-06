package com.ms.ecommerce.eshop.business.domain;

import java.util.List;

public interface Cart {

	public Integer size();
	
	public void addItem(CartItemDTO item);
	
	public void removeItem(CartItemDTO item);
	
	public List<CartItemDTO> getCartItems();		
}
