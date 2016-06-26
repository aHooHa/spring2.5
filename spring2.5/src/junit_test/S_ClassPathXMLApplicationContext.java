package junit_test;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

/**
 * 模拟板容器
 * 
 * @author SONY
 *
 */
public class S_ClassPathXMLApplicationContext {
	private List<BeanDefinition> beanDefines = new ArrayList<>();
	private Map<String, Object> sig = new HashMap<>();

	public S_ClassPathXMLApplicationContext(String filename) {
		this.readXML(filename);
		this.instanceBeans();
		this.injectObject();
	}

	private void injectObject() {
		for (BeanDefinition beanDefinition : beanDefines) {
			Object bean = sig.get(beanDefinition.getId());
			if(bean != null){
				try {
					PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
					for(ProportyDefinition propertyDefinition : beanDefinition.getProportys()){
						for(PropertyDescriptor properdesc : ps){
							if(propertyDefinition.getName().equals(properdesc.getName())){
								Method setter = properdesc.getWriteMethod();//获取属性的setter方法 ,private
								if(setter!=null){
									Object value = sig.get(propertyDefinition.getRef());
									setter.setAccessible(true);
									setter.invoke(bean, value);//把引用对象注入到属性
								}
								break;
							}
						}
					}
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * bean 的实例化
	 */
	private void instanceBeans() {
		for (BeanDefinition beanDefinition : beanDefines) {
			try {
				if (beanDefinition.getClassname() != null && !beanDefinition.getClassname().trim().equals(""))
					sig.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassname()).newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取xml配置文件
	 * 
	 * @param filename
	 */
	private void readXML(String filename) {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			URL xmlpath = this.getClass().getClassLoader().getResource(filename);
			document = saxReader.read(xmlpath);
			Map<String, String> nsMap = new HashMap<String, String>();
			nsMap.put("ns", "http://www.springframework.org/schema/beans");// 加入命名空间
			XPath xsub = document.createXPath("//ns:beans/ns:bean");// 创建beans/bean查询路径
			xsub.setNamespaceURIs(nsMap);// 设置命名空间
			List<Element> beans = xsub.selectNodes(document);// 获取文档下所有bean节点
			for (Element element : beans) {
				String id = element.attributeValue("id");// 获取id属性值
				String clazz = element.attributeValue("class"); // 获取class属性值
				BeanDefinition beanDefine = new BeanDefinition(id, clazz);
				XPath proportysub = element.createXPath("ns:property");// 创建beans/bean查询路径
				proportysub.setNamespaceURIs(nsMap);// 设置命名空间
				List<Element> propertys = proportysub.selectNodes(element);
				for (Element property : propertys) {
					String name= property.attributeValue("name");
					String ref = property.attributeValue("ref");
					ProportyDefinition propertyDe = new ProportyDefinition(name,ref);
					beanDefine.getProportys().add(propertyDe);
				}
				beanDefines.add(beanDefine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取bean方法
	 * 
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName) {
		return this.sig.get(beanName);

	}

}
