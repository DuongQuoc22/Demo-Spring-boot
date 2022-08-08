package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Phone;
import com.example.demo.entity.PhoneBrand;

public interface PhoneRepository extends JpaRepository<Phone, Integer>{
	List<Phone> findByBrandLike(PhoneBrand brand);
	List<Phone> findByNameLike(String name);
}
