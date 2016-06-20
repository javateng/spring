package spring.seiya.chapter3.helloworld;

import spring.seiya.chapter2.helloworld.HelloApi;

public class DependencyInjectByStaticFactory {
	
	public static HelloApi newInstance(String message,int index){
		return new HelloImpl3(message,index);
	}

}
