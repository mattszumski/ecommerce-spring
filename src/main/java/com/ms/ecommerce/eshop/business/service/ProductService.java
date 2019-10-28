package com.ms.ecommerce.eshop.business.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.ecommerce.eshop.business.domain.ProductDTO;
import com.ms.ecommerce.eshop.data.entity.Product;
import com.ms.ecommerce.eshop.data.entity.ProductCategory;
import com.ms.ecommerce.eshop.data.entity.ProductDetails;
import com.ms.ecommerce.eshop.data.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product saveNewProduct(ProductDTO productDTO) {
		
		Product product = new Product(0L, productDTO.getName(), productDTO.getPrice(), productDTO.getShortDescription(),
									productDTO.getLongDescription(), productDTO.getCategory(), productDTO.getKeywords(), null);
		ProductDetails productDetails = new ProductDetails(0L, productDTO.getProductsInStock(), productDTO.getShippingMethod(), ZonedDateTime.now());
		product.setProductDetails(productDetails);
		productRepository.save(product);
		return product;
	}
	
	public Product updateProduct(ProductDTO productDTO) {
		Product product = productRepository.findById(productDTO.getProductId()).get();
		product = updateProductWithDtoData(product, productDTO);
		return productRepository.save(product);
	}
	
	private Product updateProductWithDtoData(Product product, ProductDTO productDTO) {
		product.setId(productDTO.getProductId());
		if(!product.getName().equals(productDTO.getName())) {
			product.setName(productDTO.getName());
		}
		if(!product.getPrice().equals(productDTO.getPrice())) {
			product.setPrice(productDTO.getPrice());
		}
		if(!product.getShortDescription().equals(productDTO.getShortDescription())) {
			product.setShortDescription(productDTO.getShortDescription());
		}
		if(!product.getLongDescription().equals(productDTO.getLongDescription())) {
			product.setLongDescription(productDTO.getLongDescription());
		}
		if(!product.getCategory().equals(productDTO.getCategory())) {
			product.setCategory(productDTO.getCategory());
		}
		if(!product.getKeywords().equals(productDTO.getKeywords())) {
			product.setKeywords(productDTO.getKeywords());
		}
		if(!product.getProductDetails().getProductsInStock().equals(productDTO.getProductsInStock())) {
			product.getProductDetails().setProductsInStock(productDTO.getProductsInStock());
		}
		if(!product.getProductDetails().getShippingMethod().equals(productDTO.getShippingMethod())) {
			product.getProductDetails().setShippingMethod(productDTO.getShippingMethod());
		}
		
		return product;
	}

	public List<ProductDTO> getAllProducts() {
		Iterable<Product> allProducts = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		allProducts.forEach(product -> productDTOs.add(product.createDTOFromSelf()));
		return productDTOs;
	}
	
	public List<ProductDTO> getAllWithKeyword(String keyword) {
		if(keyword == null) {
			return null;
		}

		List<ProductDTO> DTOsWithKeyword = new ArrayList<>();
		this.getAllProducts().forEach(productDTO -> {
			if(productDTO.getKeywords().toLowerCase().contains(keyword.toLowerCase())) {
				DTOsWithKeyword.add(productDTO);
			}
		});
		return DTOsWithKeyword;
	}
	
	public List<ProductDTO> getAllWithCategory(ProductCategory productCategory) {
		List<ProductDTO> allWithCategory = new ArrayList<>();
		
		productRepository.findByCategory(productCategory).forEach(product -> {
			allWithCategory.add(product.createDTOFromSelf());
		});
		return allWithCategory;
	}

	public ProductDTO getProductDTOWithId(Integer productId) {
		Optional<Product> product = productRepository.findById((long)productId);
		if (product.isPresent()) {
			return product.get().createDTOFromSelf();
		} else {
			return null;
		}
	}

	public ProductDTO getProductDTOWithIdAndName(Integer productId, String productName) {
		ProductDTO productDTO = getProductDTOWithId(productId);
		if(productDTO == null) {
			return productDTO;
		}
		if(productDTO.getName().equals(productName)) {
			return productDTO;
		} else {
			return null;
		}
	}
	
	public ProductDTO getProductDTOWithName(String productName) {
		Optional<Product> product = productRepository.findByName(productName);
		if(product.isPresent()) {
			return product.get().createDTOFromSelf();
		} else {
			return null;
		}
	}
}
