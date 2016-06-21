package spring.seiya.chapter3;

import java.util.HashMap;
import java.util.Map;

public class BeanDifinitionRegister {
	
	private final Map<String,BeanDefinition> DEFINITION = new HashMap<String, BeanDefinition>();
	
	public void registerBeanDefinition(String beanName,BeanDefinition bd){
		if(DEFINITION.containsKey(bd.getId())){
			throw new RuntimeException("已存在Bean定义，此实现不允许覆盖");
		}
		DEFINITION.put(bd.getId(), bd);
	}
	public BeanDefinition getBeanDefinition(String beanName){
		return DEFINITION.get(beanName);
	}
	public boolean containsBeanDefinition(String beanName){
		return DEFINITION.containsKey(beanName);
	}

}
