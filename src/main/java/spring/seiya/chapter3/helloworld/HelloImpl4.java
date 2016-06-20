package spring.seiya.chapter3.helloworld;

import spring.seiya.chapter2.helloworld.HelloApi;

public class HelloImpl4 implements HelloApi {
	
	private String message;
	private int index;
	
	public void setMessage(String message){
		this.message= message;
	}
	public void setIndex(int index){
		this.index= index;
	}
	
	public void sayHello(){
		System.out.println(index+":"+message);
	}
}
