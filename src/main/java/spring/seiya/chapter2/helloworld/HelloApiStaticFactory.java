package spring.seiya.chapter2.helloworld;

public class HelloApiStaticFactory {
	
	public static HelloApi newInstance(String message){
		return new HelloImpl2(message);
	}

}
