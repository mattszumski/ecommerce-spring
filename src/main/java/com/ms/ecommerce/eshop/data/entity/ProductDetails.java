package com.ms.ecommerce.eshop.data.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_details_id")
	private long id;
	
	@Column(name="products_in_stock")
	private Integer productsInStock;
	
	@Column(name="shipping_method")
	@Enumerated(EnumType.STRING)
	private ShippingMethod shippingMethod;
	
	@Column(name="created_at")
	private ZonedDateTime createdAt;
	
	protected ProductDetails() {

	}

	public ProductDetails(long id, Integer productsInStock, ShippingMethod shippingMethod, ZonedDateTime createdAt) {
		this.id = id;
		this.productsInStock = productsInStock;
		this.shippingMethod = shippingMethod;
		this.createdAt = createdAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getProductsInStock() {
		return productsInStock;
	}

	public void setProductsInStock(Integer productsInStock) {
		this.productsInStock = productsInStock;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}	
	
}
