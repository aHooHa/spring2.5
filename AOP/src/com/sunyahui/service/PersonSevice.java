package com.sunyahui.service;

public interface PersonSevice {
	
	public void save(String name);
	public void update(String name,Integer personId );
	public String getPersonName(Integer personId);
}
