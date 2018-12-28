package com.day14;

//Daemon 스레드
//다른스레드에 도움을 주는 스레드로 
//다른 스레드가 종료되면 데몬스레드가 종료되지 않아도 프로세스가 종료된다.

class MyThread5 implements Runnable{

	@Override
	public void run() {
		
		for(int i=1;i<=20;i++){
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
}


public class Test5 {

	public static void main(String[] args) {
		
		System.out.println("main 시작...");
		Thread t1 = new Thread(new MyThread5());
		Thread t2 = new Thread(new MyThread5());
		Thread t3 = new Thread(new MyThread5());
		
		//데몬스레드는 main이 살아있는 만큼만 run함. 원래 스레드는 메인스레드가 종료되도 계속 실행됨. 
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			
			Thread.sleep(1000);//메인이 2초 쉼
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			t1.join();//main에게 t1이 종료할 때까지 기다리라는 명령어. Waits for this thread to die. 
			t2.join();
			t3.join();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("main 종료...");//join이 없을때, main스레드가 끝나면 데몬스레드도 같이 종료
	}

}
