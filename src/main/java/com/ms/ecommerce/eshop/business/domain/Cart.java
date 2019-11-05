package com.ms.ecommerce.eshop.business.domain;


public interface Cart {

	public Integer size();
	
	public void addItem(CartItemDTO item);
	
	public void removeItem(CartItemDTO item);
		
}
