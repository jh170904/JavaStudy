package com.day14;

//스레드 그룹
//스레드를 여러개 만들어서 사용할 때 그룹지어 사용


public class Test11 {

	public static void main(String[] args) {
		
		System.out.println("메인 스레드 그룹 : " +Thread.currentThread().getThreadGroup());//main이라는 그룹이 있는데 그안에 스레드가 있는 것. 
		System.out.println("메인 : " + Thread.currentThread());//메인스레드그룹이 들어있는 메인스레드의 정보..?
		
		Thread t1 = new Thread();
		System.out.println("t1 스레드 그룹 : " +Thread.currentThread().getThreadGroup());//t1스레드를 만들면 항상 메인스레드 그룹에 들어감
		System.out.println("t1 : " +t1);
		//Thread[Thread-0,5,main] = 스레드이름 Thread-0, 우선순위 5, main 스레드그룹에 들어있다
	
		ThreadGroup tg = new ThreadGroup("tg");//그룹이름
		Thread t2 = new Thread(tg, "t2");
		Thread t3 = new Thread(tg, "t3");
		
		System.out.println("t2 : " +t2);
		System.out.println("t3 : " +t3);
		
	
	}

}
