package com.example.demo.service;

import java.util.List;

import com.example.demo.models.login;

public interface loginservice {
	public String add(login l);

	public String delete(String email);

	public String update(login l, String email);

	public login getbyemail(String email);

	public List<login> getall();

}
