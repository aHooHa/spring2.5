package junit_test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunyahui.service.PersonService;

public class SpringTest {

	@Test
	public void test() {
		AbstractApplicationContext context =
			    new ClassPathXmlApplicationContext("beans.xml");
		PersonService  personService = (PersonService) context.getBean("personService");
		//personService.save();
		for(String value :personService.getSet()){
			System.out.println(value);
		}
		System.out.println("+++++++++properties+++++++");
		for(Object key :personService.getProperties().keySet()){
			System.out.println(key+"  "+personService.getProperties().getProperty((String)key));
		}
		System.out.println("+++++++++Map+++++++");
		for(Object key :personService.getMaps().keySet()){
			System.out.println(key+"  "+personService.getMaps().get(key));
		}
		context.close();
	}
	
}
