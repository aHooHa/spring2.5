package com.sunyahui.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.sunyahui.service.impl.PersonServiceBean;

public class JDKProxyFactory {

	private Object targerObject;

	public JDKProxyFactory() {
		super();
	}

	public Object createProxyInstance(Object targerObject) {
		this.targerObject = targerObject;
		return Proxy.newProxyInstance(this.targerObject.getClass().getClassLoader(),
				this.targerObject.getClass().getInterfaces(), (InvocationHandler) this);
	}

//	@Override
//	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//		PersonServiceBean personServiceBean = (PersonServiceBean) this.targerObject;
//		Object result = null;
//		if (personServiceBean.getUsername() != null) {
//			 result = method.invoke(targerObject, args);
//		}
//		return result;
//	}

	

}
