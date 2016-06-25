package junit_test;

public class BeanDefinition {
	private String id;
	private String classname;
	
	
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
	
}
