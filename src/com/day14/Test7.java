package com.day14;

//인터럽트
//우선순위가 높은 프로그램을 먼저 실행시키고 다시 돌아온다. 꼬리를 물면서 실행시키는 방법.

class MyThread7 extends Thread{
	
	private Thread next;
	
	public void setNext(Thread next){
		this.next=next;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			
			try {
				sleep(2000);//2초쉼
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println(getName()+":"+i);
			
			if(next.isAlive())//스레드가 살아있으면 멈춰라
				next.interrupt();//다음번 스레드를 살려내는 역할을 하는게 인터럽트
		}
	
	}
	
}
public class Test7 {

	public static void main(String[] args) {
		
		MyThread7 t1 = new MyThread7();
		MyThread7 t2 = new MyThread7();
		MyThread7 t3 = new MyThread7();
		
		t1.setNext(t2);//t1이 멈추면 t2이 살아남
		t2.setNext(t3);//t2이 멈추면 t3이 살아남
		t3.setNext(t1);//t3이 멈추면 t1이 살아남
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.interrupt();
		
	}

}
