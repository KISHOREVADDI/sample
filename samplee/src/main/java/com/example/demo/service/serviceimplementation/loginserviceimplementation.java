package com.example.demo.service.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.login;
import com.example.demo.repository.loginrepository;
import com.example.demo.service.loginservice;

import jakarta.transaction.Transactional;

@Service
public class loginserviceimplementation implements loginservice {
	@Autowired
	loginrepository repo;

	@Override
	public String add(login l) {
		repo.save(l);
		return "Successfully Inserted";
	}
@Transactional
	@Override
	public String delete(String email) {
		repo.deleteByEmail(email);
		return "Successfully Deleted" + email;
	}

	@Override
	public String update(login l, String email) {
		login l1 = repo.findByEmail(email);
		l1.setEmail(l.getEmail());
		l1.setPassword(l.getPassword());
		l1.setAddress(l.getAddress());
		repo.save(l1);

		return "Successfully Updated";
	}

	@Override
	public login getbyemail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public List<login> getall() {

		return (List<login>) repo.findAll();
	}

}
