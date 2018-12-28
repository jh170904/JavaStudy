package com.day14;

//스레드 우선순위 : 1이 가장 낮고 10이 가장 높다

class MyThread4 extends Thread{
	
	private String name;
	public MyThread4(String name){
		
		this.name = name;
		
	}
	
	@Override
	public void run() {
	
		for(int i=1;i<=20;i++){
			System.out.println(name + ":" + i);
		}

	}
	
}

public class Test4 {

	public static void main(String[] args) {

		MyThread4 ob1 = new MyThread4("A");
		MyThread4 ob2 = new MyThread4("B");
		MyThread4 ob3 = new MyThread4("C");
		
		//우선순위 종류(상수)
		System.out.println("MIN: "+ Thread.MIN_PRIORITY);	//1
		System.out.println("NORM: "+ Thread.NORM_PRIORITY);	//5
		System.out.println("MAX: "+ Thread.MAX_PRIORITY);	//10
	
		//스레드 기본 우선순위 : 모든 스레드는 기본 우선순위를 5로 가짐
		System.out.println(ob1.getPriority());//5
		System.out.println(ob2.getPriority());//5
		System.out.println(ob3.getPriority());//5
		
		//우선순위를 변경
		ob1.setPriority(Thread.MIN_PRIORITY);//1.  바로 숫자 2를 입력해도 됨
		ob2.setPriority(Thread.NORM_PRIORITY);//5.
		ob3.setPriority(Thread.MAX_PRIORITY);//10.
		
		ob1.start();
		ob2.start();
		ob3.start();
	}

}
