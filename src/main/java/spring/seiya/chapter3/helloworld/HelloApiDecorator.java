package spring.seiya.chapter3.helloworld;

import spring.seiya.chapter2.helloworld.HelloApi;

public class HelloApiDecorator implements HelloApi{
	private HelloApi helloApi;
	
	public HelloApiDecorator(){
		
	}
	public HelloApiDecorator(HelloApi helloApi){
		this.helloApi= helloApi;
	}
	public void setHelloApi(HelloApi helloApi){
		this.helloApi=helloApi;
	}
	public void sayHello(){
		System.out.println("============================");
		helloApi.sayHello();
		System.out.println("============================");
	}
	
	
}
