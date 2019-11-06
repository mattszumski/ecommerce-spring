package com.ms.ecommerce.eshop.business.domain;

import java.math.BigDecimal;

import com.ms.ecommerce.eshop.data.entity.ShippingMethod;

public class CartItemDTO {
	private Long productId;
	private String name;
	private BigDecimal price;
	private Integer amount;
	private ShippingMethod shippingMethod;
	
	public CartItemDTO () {
	}

	public CartItemDTO(Long productId, String name, BigDecimal price, Integer amount, ShippingMethod shippingMethod) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.shippingMethod = shippingMethod;
	}
	
	public CartItemDTO populateFromProductDTO(ProductDTO product) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.shippingMethod = product.getShippingMethod();
		return this;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		CartItemDTO comparingObj = (CartItemDTO) obj;
		if(this.productId != comparingObj.productId) {
			return false;
		}
		if(!this.name.equals(comparingObj.name)) {
			return false;
		}
		if(this.shippingMethod != comparingObj.shippingMethod) {
			return false;
		}
		if(!this.price.equals(comparingObj.price)) {
			return false;
		}
		// Amount is not compared on purpose as it doesn't matter - items in cart should stack
		return true;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

}
