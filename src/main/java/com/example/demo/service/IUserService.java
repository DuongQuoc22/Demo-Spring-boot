package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Users;

public interface IUserService {
	Page<Users> getByPage(int pageNumber, int maxRecord);
	Page<Users> getByType(int pageNumber, int maxRecord,String keyWord);
}
