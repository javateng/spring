package spring.seiya.chapter3;

public class Printer {
	private int counter=0;
	public void print(String type){
		System.out.println(type+" print:"+counter++);
	}

}
