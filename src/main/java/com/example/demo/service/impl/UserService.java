package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
@Service
public class UserService implements IUserService {
	@Autowired
	private IUserRepository repository;
	
	@Override
	public Page<Users> getByPage(int pageNumber, int maxRecord) {
		Pageable pageable = PageRequest.of(pageNumber, maxRecord);
		Page<Users> page = repository.findAll(pageable);
		return page;
	}

	@Override
	public Page<Users> getByType(int pageNumber, int maxRecord, String keyWord) {
		Pageable pageable = PageRequest.of(pageNumber, maxRecord);
		Page<Users> page = repository.findAllType(keyWord,pageable);
		return page;
	}
	public Page<Users> getAll(String keyWord, Pageable pageable){
		return repository.findAllType(keyWord, pageable);
	}
		
	
	public List<Users> getAll2(){
		return repository.findAll();
	}
	
	public void save(Users user) {
		repository.save(user);
	}
	
	public Optional<Users> update (Integer id) {
		return repository.findById(id);
	}
	
	public void delete(Integer id){
		repository.deleteById(id);
	}
	public Users find(Integer id) {
		Optional<Users> optional = repository.findById(id);
		Users user = null;
		if (optional.isPresent()) {
			user = optional.get();
		}else {
            throw new RuntimeException(" Không tìm thấy người dùng: " + id);
        }
		return user;
	}
}
