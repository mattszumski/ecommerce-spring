package com.ms.ecommerce.eshop.business.domain;

import java.math.BigDecimal;

import com.ms.ecommerce.eshop.data.entity.ProductCategory;
import com.ms.ecommerce.eshop.data.entity.ShippingMethod;

public class ProductDTO {
	private Long productId;
	private String name;
	private BigDecimal price;
	private String shortDescription;
	private String longDescription;
	private ProductCategory category;
	private String keywords;
	private Integer productsInStock;
	private ShippingMethod shippingMethod;
	
	public ProductDTO(Long product_id, String name, BigDecimal price, String shortDescription, String longDescription,
			ProductCategory category, String keywords, Integer productsInStock, ShippingMethod shippingMethod) {
		this.productId = product_id;
		this.name = name;
		this.price = price;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.category = category;
		this.keywords = keywords;
		this.productsInStock = productsInStock;
		this.shippingMethod = shippingMethod;
	}
	
	public ProductDTO () {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long product_id) {
		this.productId = product_id;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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
}
