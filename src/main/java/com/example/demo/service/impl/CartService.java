package com.example.demo.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Phone;
import com.example.demo.entity.Users;
import com.example.demo.repository.ICartRepository;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.service.ICartService;
@Repository

public class CartService implements ICartService{
	@Autowired private ICartRepository cartRepository;
	@Autowired private PhoneRepository phoneRepository;
	
	public CartService(ICartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	@Override
	public List<Cart> getAll(Integer idUser) {
		// TODO Auto-generated method stub
		return cartRepository.findAll(idUser);
	}

	@Override
	public Integer addToCart(Integer id, Integer quantity, Users user) {
		// TODO Auto-generated method stub
		Integer sl = quantity;
		Phone fone = phoneRepository.findById(id).get();
		
		Cart cart = cartRepository.findByUserAndPhone(user, fone);
		if(cart != null) {
			
			cart.setQuantity(sl);
		}else {
			cart = new Cart();
			cart.setQuantity(quantity);
			cart.setUser(user);
			cart.setPhone(fone);
		}
		cartRepository.save(cart);
		return sl;
	}

	@Override
	public List<Cart> listCart(Users user) {
		// TODO Auto-generated method stub
		return cartRepository.findByUser(user);
	}
	public void delete(Integer id) {
		if (id!=null) {
			Optional<Cart> cart = cartRepository.findById(id);
			if (cart.isPresent()) {
				cartRepository.deleteById(id);
				cart.get();
				return;
			}
		}
		return;
	}
	
	public Cart update(Integer id) {
		Optional<Cart> optional = cartRepository.findById(id);
		Cart cart = null;
		if (optional.isPresent()) {
			cart = optional.get();
		}else {
			throw new RuntimeException("Không tìm thất mã: " + id);
		}
		return cart;
	}
	
}
