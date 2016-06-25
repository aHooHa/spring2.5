package com.sunyahui.service.impl;

import com.sunyahui.service.PersonService;

public class PersonServiceBean implements PersonService {

	@Override
	public void save() {
		System.out.println("woshi,save()方法");
	}
	
	public void init(){
		System.out.println("初始化方法");
	}
	public void destroy(){
		System.out.println("方法销毁");
	}
}
