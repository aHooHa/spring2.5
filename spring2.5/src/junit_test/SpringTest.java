package junit_test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunyahui.service.PersonService;

public class SpringTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context =
			    new ClassPathXmlApplicationContext("beans.xml");
//		PersonService person = (PersonService) context.getBean("personService3");
//		person.save();
		context.close();
	}

}
