package com.sunyahui.dao.impl;

import org.springframework.stereotype.Repository;

import com.sunyahui.dao.PersonDao;

@Repository
public class PersonDaoBean implements PersonDao {
	@Override
	public void add(){
		System.out.println("这是persondaobean（）方法");
	}
}
