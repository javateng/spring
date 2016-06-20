package spring.seiya.chapter2.helloworld;

public class HelloImpl2 implements HelloApi {

	private String message;
	public HelloImpl2(){
		this.message="Hello World2!";
	}
	public HelloImpl2(String message){
		this.message= message;
	}
	
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(message);
	}
	

}
