package spring.seiya.chapter2.helloworld;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest2 {
	
	@Test
	//使用构造器实例化Bean
	public void testInstantiatingBeanByConstructor(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/instantiatingBean.xml");
		HelloApi bean1 = beanFactory.getBean("bean1",HelloApi.class);
		bean1.sayHello();
		
		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();	
	}
	
	@Test
	/*使用静态工厂方式实例化Bean，使用这种方式除了指定必须的class属性，
	 * 还要指定factory-method属性来指定实例化Bean的方法，
	 * 而且使用静态工厂方法也允许指定方法参数*/
	public void testInstantiatingBeanByStaticFactory(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/instantiatingBean.xml");
		HelloApi bean3 = beanFactory.getBean("bean3",HelloApi.class);
		bean3.sayHello();
	}
	
	@Test
	public void testInstantiatingBeanByInstanctFactory(){
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/instantiatingBean.xml");
		HelloApi bean4 = beanFactory.getBean("bean4",HelloApi.class);
		bean4.sayHello();
	}
	
	

}
