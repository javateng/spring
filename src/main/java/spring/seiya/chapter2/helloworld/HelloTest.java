package spring.seiya.chapter2.helloworld;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;

public class HelloTest {
	@Test
	public void testHelloWorld() {
		// 1、读取配置文件实例化一个IoC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("helloworld.xml");
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		HelloApi helloApi = context.getBean("hello", HelloApi.class);
		// 3、执行业务逻辑
		helloApi.sayHello();
	}

	@Test
	// 不指定id，只配置必须的全限定类名，由IoC容器为其生成一个标识，客户端必须通过接口“T getBean(Class<T>
	// requiredType)”获取Bean
	public void test1() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/namingbean1.xml");
		HelloApi helloApi = beanFactory.getBean(HelloApi.class);
		helloApi.sayHello();
	}

	@Test
	// 指定id，必须在Ioc容器中唯一
	public void test2() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/namingbean2.xml");
		HelloApi helloApi = beanFactory.getBean("bean2", HelloApi.class);
		helloApi.sayHello();
	}

	@Test
	// 指定name，这样name就是“标识符”，必须在Ioc容器中唯一；
	public void test3() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/namingbean3.xml");
		HelloApi helloApi = beanFactory.getBean("bean", HelloApi.class);
		helloApi.sayHello();
	}

	@Test
	// 指定id和name，id就是标识符，而name就是别名，必须在Ioc容器中唯一
	public void test4() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/namingbean4.xml");
		// 根据id获取bean
		HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		// 根据别名获取bean
		HelloApi bean2 = beanFactory.getBean("alias1", HelloApi.class);
		bean2.sayHello();
		// 根据id获取bean
		HelloApi bean4 = beanFactory.getBean("bean4", HelloApi.class);
		bean4.sayHello();
		String[] bean3Alias = beanFactory.getAliases("bean4");
		// 因此别名不能和id一样，如果一样则由IoC容器负责消除冲突
		Assert.assertEquals(0, bean3Alias.length);
	}

	@Test

	public void test5() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter2/namingbean5.xml");
		// 1根据id获取bean
		HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		// 2根据别名获取bean
		HelloApi alias11 = beanFactory.getBean("alias11", HelloApi.class);
		alias11.sayHello();
		// 3验证确实是四个别名
		String[] bean1Alias = beanFactory.getAliases("bean1");
		System.out.println("=======namingbean5.xml bean1 别名========");
		for (String alias : bean1Alias) {
			System.out.println(alias);
		}
		Assert.assertEquals(4, bean1Alias.length);
		// 根据id获取bean
		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();
		// 2根据别名获取bean
		HelloApi alias21 = beanFactory.getBean("alias21", HelloApi.class);
		alias21.sayHello();
		// 验证确实是两个别名
		String[] bean2Alias = beanFactory.getAliases("bean2");
		System.out.println("=======namingbean5.xml bean2 别名========");
		for (String alias : bean2Alias) {
			System.out.println(alias);
		}
		Assert.assertEquals(2, bean2Alias.length);

	}
}
