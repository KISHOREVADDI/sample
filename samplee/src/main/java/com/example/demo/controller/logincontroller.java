package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.login;
import com.example.demo.service.loginservice;

@RestController
@RequestMapping("/api/v1")
public class logincontroller {
	@Autowired
	loginservice service;
@PostMapping("/login")
	public String add(@RequestBody login l) {
		return service.add(l);
	}
@DeleteMapping("/login/{email}")
	public String delete(@PathVariable String email) {
		return service.delete(email);

	}
@PutMapping("/updatelogin")
	public String update(@RequestBody login l,@PathVariable String email) {
		return service.update(l, email);
	}
@GetMapping("/logins/{email}")
	public login getbyemail(@PathVariable String email) {
		return service.getbyemail(email);

	}
@GetMapping("/logins")
	public List<login> getall() {
		return  service.getall();
	}
}
