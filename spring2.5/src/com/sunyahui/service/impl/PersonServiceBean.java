package com.sunyahui.service.impl;


import org.springframework.stereotype.Service;

import com.sunyahui.dao.PersonDao;
import com.sunyahui.service.PersonService;

@Service
public class PersonServiceBean implements PersonService {

	
	private PersonDao personDao;
	
	
	public PersonServiceBean(PersonDao personDao) {
		super();
		this.personDao = personDao;
	}


	@Override
	public void save() {
		personDao.add();
	}

	

	
}
