package com.ms.ecommerce.eshop.web.application;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ms.ecommerce.eshop.security.domain.EShopUserDetails;
import com.ms.ecommerce.eshop.security.entity.User;

@SessionAttributes({"currentUser"})
@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/loginFailed", method = RequestMethod.GET)
	public String loginError(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(SessionStatus session) {
		SecurityContextHolder.getContext().setAuthentication(null);
		session.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="/postLogin", method = RequestMethod.POST)
	public String postLogin(HttpSession  session, Model model) {
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());
		
		 User loggedInUser = ((EShopUserDetails) authentication.getPrincipal()).getUser();
	        model.addAttribute("currentUser", loggedInUser.getUsername());
	        session.setAttribute("userId",  loggedInUser.getId());
	        return "redirect:/";
	}
	

    private void validatePrinciple(Object principal) {
        if (!(principal instanceof EShopUserDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }
}
