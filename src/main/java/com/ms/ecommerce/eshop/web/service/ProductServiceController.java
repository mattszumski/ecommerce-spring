package com.ms.ecommerce.eshop.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.ecommerce.eshop.business.domain.ProductDTO;
import com.ms.ecommerce.eshop.business.service.ProductService;

@RestController
@RequestMapping(value="/api")
public class ProductServiceController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public List<ProductDTO> getProductWithKeyWord(@RequestParam("keyword")String keyword) {
		return productService.getAllWithKeyword(keyword);
	}
	
	@RequestMapping(value="/products")
	public List<ProductDTO> getProductWithName () {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/products/name/{productName}")
	public ProductDTO getProductWithName (@PathVariable("productName") String productName) {
		return productService.getProductDTOWithName(productName);
	}
	
	@RequestMapping(value="/products/id/{productId}")
	public ProductDTO getProductWithName (@PathVariable("productId") Integer productId) {
		return productService.getProductDTOWithId(productId);
	}
}
