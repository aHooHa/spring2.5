package com.sunyahui.aop;

import java.lang.reflect.Method;

import com.sunyahui.service.impl.PersonServiceBean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibFactory implements MethodInterceptor {

	private Object tergetObject;

	public Object createProxyInstance(Object targetObject) {

		this.tergetObject = targetObject;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.tergetObject.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		
		PersonServiceBean personServiceBean = (PersonServiceBean) this.tergetObject;
		Object result = null;
		if (personServiceBean.getUsername() != null) {
			 result = methodProxy.invoke(tergetObject, objects);
		}
		
		return result;
		
		
	}
}
