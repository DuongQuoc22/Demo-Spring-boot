package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Users;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.service.impl.CartService;
import com.example.demo.service.impl.UserService;




@Controller
public class CartController {
	@Autowired
	 HttpSession session;
	@Autowired
	private PhoneRepository phoneRep;
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;
	@Autowired 
	 HttpServletRequest request;
	
	@GetMapping("/shopping/cart")
	public String viewCart(ModelMap modelMap, Model model) {
//		int iduser = ((Users) request.getSession().getAttribute("user")).getId();
//		List<Cart> cart = cartService.listCart(userService.find(iduser));
//		modelMap.addAttribute("cart", cart);
//		
//		return "shopping/cart";
		Users u = (Users) session.getAttribute("user");
		if(u != null) {
			int iduser = ((Users) request.getSession().getAttribute("user")).getId();
			List<Cart> cart = cartService.listCart(userService.find(iduser));
			modelMap.addAttribute("cart", cart);
			
			return "shopping/cart";
		}else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/shopping/cart/{id}/{quantity}")
	public String addCart(@PathVariable("id") Integer id, @PathVariable("quantity")Integer quantity) {
		
		Users u = (Users) session.getAttribute("user");
		if(u != null) {
			Integer iduser = ((Users) request.getSession().getAttribute("user")).getId();
			cartService.addToCart(id, quantity, userService.find(iduser));
			return "redirect:/shopping/cart";
		}else {
			return "redirect:/login";
		}
	}
	@GetMapping("/shopping/delete/{id}")
	public String deleteCart(@PathVariable("id")Integer id) {
		cartService.delete(id);
		return "redirect:/shopping/cart";
	}
	@GetMapping("/shopping/cart/{id}")
	public String updateQuantity(@PathVariable("id") Integer id, @RequestParam(name="soluong") Integer quantity,Cart cart) {
		Integer iduser = ((Users) request.getSession().getAttribute("user")).getId();
		cartService.addToCart(id, quantity, userService.find(iduser));
		
		return "redirect:/shopping/cart";
	}
}
