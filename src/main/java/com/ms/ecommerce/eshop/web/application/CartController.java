package com.ms.ecommerce.eshop.web.application;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.ecommerce.eshop.business.domain.CartItemDTO;
import com.ms.ecommerce.eshop.business.service.CartService;

@Controller
public class CartController {
	
	@RequestMapping(value="/addToCart", method = RequestMethod.POST)
	public String addToCart(@ModelAttribute("cartItemDTO") CartItemDTO dto, HttpSession session) {
		CartService cartService = (CartService) session.getAttribute("cart");
		cartService.addItem(dto);
		return "redirect:/";
	}

}
