package junit_test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunyahui.service.impl.PersonService1;

public class SpringTest {

	@Test
	public void test() {
		ApplicationContext context =
			    new ClassPathXmlApplicationContext("beans.xml");
		PersonService1  personService = (PersonService1) context.getBean("personService");
		//personService.save();
//		for(String value :personService.getSet()){
//			System.out.println(value);
//		}
//		System.out.println("+++++++++properties+++++++");
//		for(Object key :personService.getProperties().keySet()){
//			System.out.println(key+"  "+personService.getProperties().getProperty((String)key));
//		}
//		System.out.println("+++++++++Map+++++++");
//		for(Object key :personService.getMaps().keySet()){
//			System.out.println(key+"  "+personService.getMaps().get(key));
//		}
		
		personService.save();
	
	}
	
}
