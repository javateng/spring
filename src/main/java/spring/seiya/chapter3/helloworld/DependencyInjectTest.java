package spring.seiya.chapter3.helloworld;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;
import spring.seiya.chapter2.helloworld.HelloApi;

public class DependencyInjectTest {
	
	@Test
	public void test1(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/constructorDependencyInject.xml");

		HelloApi bean1 = beanFactory.getBean("byIndex", HelloApi.class);
		bean1.sayHello();
		
		HelloApi bean2 = beanFactory.getBean("byType",HelloApi.class);
		bean2.sayHello();
		
		HelloApi bean3 = beanFactory.getBean("byName",HelloApi.class);
		bean3.sayHello();
	}
	
	@Test
	public void test2(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/staticFactoryDependencyInject.xml");
		HelloApi bean1 = beanFactory.getBean("byIndex", HelloApi.class);
		bean1.sayHello();
		
		HelloApi bean2 = beanFactory.getBean("byType",HelloApi.class);
		bean2.sayHello();
		
		HelloApi bean3 = beanFactory.getBean("byName",HelloApi.class);
		bean3.sayHello();
	}
	
	@Test
	public void test3(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/instanceFactoryDependencyInject.xml");
		HelloApi bean1 = beanFactory.getBean("byIndex", HelloApi.class);
		bean1.sayHello();
		
		HelloApi bean2 = beanFactory.getBean("byType",HelloApi.class);
		bean2.sayHello();
		
		HelloApi bean3 = beanFactory.getBean("byName",HelloApi.class);
		bean3.sayHello();
		
	}
	
	@Test
	//setterDependencyInject.xml
	public void test4(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/setterDependencyInject.xml");
		HelloApi bean1 = beanFactory.getBean("bean", HelloApi.class);
		bean1.sayHello();
	}
	
	@Test
	//booleanInject.xml
	public void test5(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/booleanInject.xml");
		BooleanTestBean bean1 = beanFactory.getBean("booleanBean", BooleanTestBean.class);
		if(bean1.isSuccess()){
			System.out.println("OK");
		}
		BooleanTestBean bean2 = beanFactory.getBean("booleanBean2", BooleanTestBean.class);
		if(bean2.isSuccess()){
			System.out.println("OK2");
		}
		BooleanTestBean bean3 = beanFactory.getBean("booleanBean3", BooleanTestBean.class);
		if(bean3.isSuccess()){
			System.out.println("OK3");
		}
		BooleanTestBean bean4 = beanFactory.getBean("booleanBean4", BooleanTestBean.class);
		if(bean4.isSuccess()){
			System.out.println("OK4");
		}
	}
	
	@Test
	//注入Bean ID
	public void test6(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/idRefInject.xml");
		IdRefTestBean bean1 = beanFactory.getBean("idrefBean1",IdRefTestBean.class);
		System.out.println(bean1.getId());
		
		IdRefTestBean bean2 = beanFactory.getBean("idrefBean2",IdRefTestBean.class);
		System.out.println(bean2.getId());
	}

	@Test
	//
	public void testListInject(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/listInject.xml");
		ListTestBean bean = beanFactory.getBean("listBean", ListTestBean.class);
		System.out.println(bean.getValues().size());
		
		Assert.assertEquals(3, bean.getValues().size());
	}
}
