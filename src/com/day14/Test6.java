package com.day14;

//스레드 생명주기(Time to live)

class MyThread6 extends Thread{
	
	@Override
	public void run() {
	
		try {
			System.out.println("스레드 시작..");
			System.out.println("우선순위: " + getPriority());
			System.out.println("스레드 이름: " + getName());//첫번째 만들어지는 스레드의 내부적인 이름 : Thread-0
			
			sleep(500);//0.5초 쉼
			
			//우선순위 변경
			setPriority(2);
			System.out.println("변경된 우선순위: " + getPriority());
			
			System.out.println("스레드 종료..");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}


public class Test6 {

	public static void main(String[] args){
		
		Thread t1 = Thread.currentThread();//현재 스레드(=main 스레드)를 t1에 할당. 
		Thread t2 = new MyThread6();//upcast. MyThread6가 가지고 있는 메소드중 부모클래스가 없는게 있다면 upcast 안됨
		
		System.out.println("main스레드 우선순위: " + t1.getPriority());//모든 스레드는 디폴트가 5
		System.out.println("main스레드 이름: "+ t1.getName());//main
		System.out.println("start()메소드 호출 전의 isAlive: " + t2.isAlive());//start이전이므로 당연히 false
		
		t2.start();
		
		//t2의 우선순위
		System.out.println("t2의 우선순위: " + t2.getPriority());
		
		//t2의 우선순위 변경(5->1)
		t2.setPriority(1);
		
		try {
			//0.1초 쉼
			Thread.sleep(100);
			
			//t2종료확인
			System.out.println("t2 살아있냐? " + t2.isAlive());
			
			//1초 쉼
			Thread.sleep(1000);
			
			//t2종료확인
			System.out.println("1초후 t2 살아있냐? " + t2.isAlive());
			
			t2.join();//main스레드 wait요청. 이미 t2가 종료되어있으므로 join해도 종료되어있음. 한번 종료된 스레드는 다시 살릴 수 없음
			System.out.println("t2 그래도 살아있냐? " + t2.isAlive());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
