package spring.seiya.chapter3;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

public class DefaultBeanFactory {
	private BeanDifinitionRegister DEFINITIONS = new BeanDifinitionRegister();
	private final SingletonBeanRegistry SINGLETONS = new SingletonBeanRegister();
	
	private Object createBean(BeanDefinition bd){
		try{
		Class clazz = Class.forName(bd.getClazz());
		return clazz.getConstructor().newInstance();
		}catch(ClassNotFoundException e){
			throw new RuntimeException("没有找到Bean[" + bd.getId() + "]类");
		}catch(Exception e){
			throw new RuntimeException("创建Bean[" + bd.getId() + "]失败");
		}
	}
	
	
	public Object getBean(String beanName){
		//1.验证Bean定义是否存在
		if(!DEFINITIONS.containsBeanDefinition(beanName)){
			throw new RuntimeException("不存在[" + beanName + "]Bean定义");
		}
		//2.获取Bean定义
		BeanDefinition bd = DEFINITIONS.getBeanDefinition(beanName);
		//
		if(bd.getScope()==BeanDefinition.SCOPE_SINGLETON){
			if(SINGLETONS.containsSingleton(beanName)){
				return SINGLETONS.getSingleton(beanName);
			}
			SINGLETONS.registerSingleton(beanName, createBean(bd));
			return SINGLETONS.getSingleton(beanName);
		}
		if(bd.getScope()==BeanDefinition.SCOPE_PROTOTYPE){
			return createBean(bd);
		}
		throw new RuntimeException("错误的Bean定义");
		
	}
	
	public void registerBeanDefinition(BeanDefinition bd) {  
	     DEFINITIONS.registerBeanDefinition(bd.getId(), bd);  
	 }

}
