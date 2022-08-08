package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Phone;

public interface IService {
	List<Phone> getAllPhone();
	void savePhone(Phone phone);
	void deletePhone(Integer id);
	Optional<Phone> findPhoneById(Integer id);
	Phone updatePhone(Phone phone);
	Page<Phone> getByPage(int pageNumber, int maxRecord);
}
