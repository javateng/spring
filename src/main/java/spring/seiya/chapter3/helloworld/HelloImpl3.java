package spring.seiya.chapter3.helloworld;

import spring.seiya.chapter2.helloworld.HelloApi;

public class HelloImpl3 implements HelloApi{
	
	private String message;
	private int index;
	
	//@java.beans.ConstructorProperties({"message", "index"})
	public HelloImpl3(String message, int index){
		this.message= message;
		this.index= index;
	}
	
	public void sayHello(){
		System.out.println(index+":"+message);
	}

}
