package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Users;

public interface ICartService {
	public List<Cart> getAll(Integer id);
	public Integer addToCart(Integer phoneId, Integer quantity, Users user);
	
	List<Cart> listCart(Users user);
}
