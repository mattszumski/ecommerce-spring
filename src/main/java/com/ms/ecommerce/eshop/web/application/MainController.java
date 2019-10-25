package com.ms.ecommerce.eshop.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.ecommerce.eshop.business.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("data", productService.getAllProducts());
		return "getList";
	}
}
