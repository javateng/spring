package spring.seiya.chapter3;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.seiya.chapter2.helloworld.HelloImpl2;

public class BeanTest {

	@Test
	public void testPrototype() throws Exception {
		// 1.创建Bean工厂
		DefaultBeanFactory bf = new DefaultBeanFactory();
		// 2.创建原型 Bean定义
		BeanDefinition bd = new BeanDefinition();
		bd.setId("bean");
		//bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		bd.setScope(BeanDefinition.SCOPE_SINGLETON);
		bd.setClazz(HelloImpl2.class.getName());
		bf.registerBeanDefinition(bd);
		// 对于原型Bean每次应该返回一个全新的Bean
		System.out.println(bf.getBean("bean") != bf.getBean("bean"));
	}
	
	@Test
	//测试scope
	public void testPrint(){
		BeanFactory bf = new ClassPathXmlApplicationContext("chapter3/printBeanInject.xml");
		System.out.println(bf.getBean("bean",Printer.class)!=bf.getBean("bean",Printer.class));
		 
		
	}

}
