package com.day14;

//Thread(스레드) : 자바로 멀티태스킹 하는 것을 가능하게 만드는 객체
//스레드 => 프로세스 내부에서 실행되는 명령 모임
//CPU가 지시해서 스레드 하나하나마다 작업을 시킴. 스레드들이 작업을 할땐 절대 중복되지 않음 

//V3 바이러스검사시(이게 하나의 프로세스) 섹터를 한번에 쭉 검사를 하게되면 너무 오래걸림.
//논리적으로 섹터를 구분하여 동시에 검사함. -> 이때 사용되는 개념이 스레드

//다중스레드 동시에 명령이 실행가능. 스레드마다 번갈아서 빠르게 실행되서 동시실행으로 보임
//클래스는 다중상속이 안됨. ClassA extends ClassB,Thread <- 불가능! 이럴땐 Runnable 인터페이스 이용


//스레드가 움직이는 기본적인 구조
class MyThread extends Thread {// Thread클래스 상속받아서 사용 가능
	private int num;
	private String name;

	public MyThread(int num, String name) {
		this.num = num;
		this.name = name;
	}

	@Override
	public void run() {// Thread클래스. 다양한 메소드 존재. 가장 중요한 건 run!. 스레드 사용시 반드시 런을 정의해줘야 함
		int i = 0;
		while (i < num) {

			System.out.println(this.getName() + ":" + name + i);
			i++;

			// run() 안에는 무조건 try안에 sleep이 있어야 함!
			try {

				sleep(100); // 100-> 0.1초, 1000->1초. 메소드가 0.1초 만큼 쉬는 시간을 줌

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}

public class Test1 {//t1과 t2는 별개의 프로그램

	public static void main(String[] args) {

		System.out.println("main 시작......");
		MyThread t1 = new MyThread(100, "첫번째 : "); //t1이 쉬는 sleep 0.1초 찰나의 시간에 t2가 올라감. 그래서 전체적인 흐름이 번갈아서 출력이 되는 것
		MyThread t2 = new MyThread(200, "두번째 : ");
		
		t1.start();//스레드호출메소드(run()메소드)
		t2.start();
		
		//스레드 3개가 실행된 것 (main, t1, t2)
		
		
		System.out.println("main 종료......");

	}

}
