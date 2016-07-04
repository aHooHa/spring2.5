package junit4te;


import org.junit.Test;

import com.sunyahui.aop.CGlibFactory;
import com.sunyahui.aop.JDKProxyFactory;
import com.sunyahui.service.PersonSevice;
import com.sunyahui.service.impl.PersonServiceBean;

public class TestAop {

	@Test
	public void test() {
		JDKProxyFactory jdkProxyFactory = new JDKProxyFactory();
		 PersonSevice personSevice = (PersonSevice) jdkProxyFactory.createProxyInstance(new PersonServiceBean("XXX"));
		 personSevice.save("sahjhdsj");
	}
	@Test
	public void test1() {
		CGlibFactory jdkProxyFactory = new CGlibFactory();
		PersonSevice personSevice = (PersonSevice) jdkProxyFactory.createProxyInstance(new PersonServiceBean());
		personSevice.save("s999");
	}

}
