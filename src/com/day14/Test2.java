package com.day14;

//Runnable 인터페이스를 이용한 스레드 
class MyThread2 implements Runnable {

	private int num;
	private String name;

	public MyThread2(int num, String name) {
		this.num = num;
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < num) {

			System.out.println(name + ":" + i);
			i++;

			try {

				Thread.sleep(100);

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}

public class Test2 {

	public static void main(String[] args) {
		
		System.out.println("main 시작....");
		Thread t1 = new Thread(new MyThread2(100, "첫번째"));
		Thread t2 = new Thread(new MyThread2(200, "두번째"));
		
		//실행순서는 CPU가 조정하여 정확하게 일치시킬 순 없음
		t1.start();
		t2.start();
		
		//스레드 3개가 실행된 것 (main, t1, t2)
		
		System.out.println("main 종료....");//메인스레드가 종료되도 t1,t2는 계속 진행
		
	}

}
