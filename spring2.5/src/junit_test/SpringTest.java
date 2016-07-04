package junit_test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunyahui.service.PersonService;

public class SpringTest {

	@Test
	public void test() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService = (PersonService) context.getBean("personServiceBean");
		System.out.println(personService);
		context.close();
	}

}
