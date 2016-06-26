package junit_test;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
	private String id;
	private String classname;
	private List<ProportyDefinition> proportys = new ArrayList<>();
	
	public BeanDefinition() {
		super();
	}


	public BeanDefinition(String id, String classname) {
		super();
		this.id = id;
		this.classname = classname;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getClassname() {
		return classname;
	}


	public void setClassname(String classname) {
		this.classname = classname;
	}


	public List<ProportyDefinition> getProportys() {
		return proportys;
	}


	public void setProportys(List<ProportyDefinition> proportys) {
		this.proportys = proportys;
	}
	
}
