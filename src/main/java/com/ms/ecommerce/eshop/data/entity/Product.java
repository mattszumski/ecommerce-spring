package com.ms.ecommerce.eshop.data.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ms.ecommerce.eshop.business.domain.ProductDTO;


@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="short_description")
	private String shortDescription;
	
	@Column(name="long_description")
	private String longDescription;
	
	@Column(name="category")
	@Enumerated(EnumType.STRING)
	private ProductCategory category;
	
	@Column(name="keywords")
	private String keywords;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_details_id")
	private ProductDetails productDetails;

	public Product() {
	}

	public Product(Long id, String name, BigDecimal price, String shortDescription, String longDescription,
			ProductCategory category, String keywords, ProductDetails productDetails) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.category = category;
		this.keywords = keywords;
		this.productDetails = productDetails;
	}

	public ProductDTO createDTOFromSelf() {
		return new ProductDTO(	this.id, this.name, this.price, 
								this.shortDescription, this.longDescription,
								this.category,this.keywords,
								this.productDetails.getProductsInStock(),
								this.productDetails.getShippingMethod());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

}
