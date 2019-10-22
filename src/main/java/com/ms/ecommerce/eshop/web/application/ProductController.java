package com.ms.ecommerce.eshop.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ms.ecommerce.eshop.business.domain.ProductDTO;
import com.ms.ecommerce.eshop.business.service.ProductService;
import com.ms.ecommerce.eshop.data.entity.ProductCategory;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/newProduct", method=RequestMethod.GET)
	public String saveNewProduct() {
		return "saveNewProduct";
	}
	
	@RequestMapping(value="/newProduct", method=RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("productDTO") ProductDTO dto) {
		productService.saveNewProduct(dto);
		return "redirect:/";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("data", productService.getAllProducts());
		return "getList";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String searchWithKeyword(@RequestParam(name="keyword", required=false) String searchedKeyword,
									@RequestParam(name="category", required=false) ProductCategory searchedCategory,
									Model model) {
		if(searchedKeyword != null) {
			model.addAttribute("data", productService.getAllWithKeyword(searchedKeyword));
		} else if(searchedCategory != null) {
			model.addAttribute("data", productService.getAllWithCategory(searchedCategory));
		} else {
			model.addAttribute("data", productService.getAllProducts());
		}
		return "getList";
	}

	@RequestMapping(value="/{productName}-{productId}")
	public String getProduct(@PathVariable("productName") String productName, @PathVariable("productId") Integer productId, Model model) {
		ProductDTO productWithID = productService.getProductDTOWithIdAndName(productId, productName);
		model.addAttribute("product", productWithID);
		return "getProduct"; 
	}
	
}
