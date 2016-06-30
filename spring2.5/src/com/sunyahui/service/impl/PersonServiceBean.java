package com.sunyahui.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.sunyahui.dao.impl.PersonDaoBean;
import com.sunyahui.service.PersonService;

public class PersonServiceBean implements PersonService {

	private PersonDaoBean personDaoBean;
	private String name;
	private Set<String> set = new HashSet<>();
	private Properties properties = new Properties();
	private Map<String,String> maps = new HashMap<>();
	
	public PersonDaoBean getPersonDaoBean() {
		return personDaoBean;
	}



	public void setPersonDaoBean(PersonDaoBean personDaoBean) {
		this.personDaoBean = personDaoBean;
	}


	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	


	public Set<String> getSet() {
		return set;
	}



	public void setSet(Set<String> set) {
		this.set = set;
	}



	public Properties getProperties() {
		return properties;
	}



	public void setProperties(Properties properties) {
		this.properties = properties;
	}



	public Map<String, String> getMaps() {
		return maps;
	}



	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}



	@Override
	public void save() {
		System.out.println(name);
		personDaoBean.add();
	}
	
//	public void init(){
//		System.out.println("初始化方法");
//	}
//	public void destroy(){
//		System.out.println("方法销毁");
//	}
}
