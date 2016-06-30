package com.sunyahui.dao.impl;

import com.sunyahui.dao.PersonDao;

public class PersonDaoBean implements PersonDao {
	@Override
	public void add(){
		System.out.println("这是persondaobean（）方法");
	}
}
