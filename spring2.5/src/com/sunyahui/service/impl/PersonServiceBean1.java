package com.sunyahui.service.impl;


import javax.annotation.Resource;

import com.sunyahui.dao.PersonDao;

public class PersonServiceBean1 implements PersonService1  {

	@Resource
	private PersonDao personDao;
	private String name;
	
	
	
	
	public PersonServiceBean1() {
		super();
	}


	public PersonServiceBean1(PersonDao personDao, String name) {
		super();
		this.personDao = personDao;
		this.name = name;
	}


	@Override
	public void save() {
		personDao.add();
		//System.out.println(name);
	}
	
	
}
