package com.sunyahui.service.impl;

import com.sunyahui.service.PersonSevice;

public class PersonServiceBean implements PersonSevice {
	
	
	private String username = null;
	
	
	public String getUsername() {
		return username;
	}

	public PersonServiceBean() {
		super();
	}

	public PersonServiceBean(String username) {
		super();
		this.username = username;
	}

	@Override
	public void save(String name) {
		System.out.println("this is save");

	}

	@Override
	public void update(String name, Integer personId) {
		System.out.println("this is update");
	}

	@Override
	public String getPersonName(Integer personId) {
		System.out.println("this is getPersonName");
		return "XXX";
	}

}
