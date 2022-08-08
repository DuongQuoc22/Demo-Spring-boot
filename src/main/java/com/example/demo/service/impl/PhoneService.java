package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Phone;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.service.IService;

@Service
public class PhoneService implements IService {
	@Autowired
	private PhoneRepository repository;

	@Override
	public List<Phone> getAllPhone() {
		// TODO Auto-generated method stub
		return (List<Phone>) repository.findAll();
	}

	@Override
	public void savePhone(Phone phone) {
		// TODO Auto-generated method stub
		phone.setId(null);
		repository.save(phone);
	}

	@Override
	public void deletePhone(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Optional<Phone> findPhoneById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Phone updatePhone(Phone phone) {
		// TODO Auto-generated method stub
		Integer id = phone.getId();
		if(id != null) {
			Optional<Phone> fone = repository.findById(id);
			if(fone.isPresent()) {
				return repository.save(phone);
			}
		}
		return null;
	}

	@Override
	public Page<Phone> getByPage(int pageNumber, int maxRecord) {
		Pageable pageable = PageRequest.of(pageNumber, maxRecord);
		Page<Phone> page = repository.findAll(pageable);
		return page;
	}

	
}
