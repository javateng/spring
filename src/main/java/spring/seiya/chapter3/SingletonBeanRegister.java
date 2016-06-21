package spring.seiya.chapter3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

public class SingletonBeanRegister implements SingletonBeanRegistry {
	
	//单例Bean缓存池，此处不考虑并发
	private final Map<String,Object> BEANS = new HashMap<String, Object>();

	public boolean containsSingleton(String beanName) {
		// TODO Auto-generated method stub
		return BEANS.containsKey(beanName);
	}

	public Object getSingleton(String beanName) {
		// TODO Auto-generated method stub
			return BEANS.get(beanName);
	}

	public int getSingletonCount() {
		// TODO Auto-generated method stub
		return BEANS.size();
	}

	public String[] getSingletonNames() {
		// TODO Auto-generated method stub
		return BEANS.keySet().toArray(new String[0]);
	}

	public void registerSingleton(String beanName, Object bean) {
		// TODO Auto-generated method stub
		if(BEANS.containsKey(beanName)){
			throw new RuntimeException("[" + beanName + "] 已存在");
		}
		BEANS.put(beanName, bean);
		
	}

}
