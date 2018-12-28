package com.day14;

class MyThread9 implements Runnable{
	
	private int bank = 10000;
	private int getBank(){
		return bank;
	}
	
	//wait() 메소드,  notify() 메소드 는 동기화 블록 synchronized(){} 에서만 사용
	private int drawMoney(int m){
		
		if(getBank()>0){
			bank -= m ;
			System.out.println(Thread.currentThread().getName() + ",인출: " +m +", 잔액:" + bank);
			
		}else{
			m=0;
			System.out.println(Thread.currentThread().getName() + "잔액부족!");
		}
			
		return m;
		
	}

	@Override
	public void run() {

		synchronized (this) {// 클래스 자체가 들어와야함. 클래스 자체가 스레드.

			for (int i = 0; i <= 10; i++) {

				if (getBank() <= 0) {
					this.notifyAll();// 대기상태의 모든스레드를 시작
					break;
				}

				drawMoney(1000);

				if (getBank() == 2000 || getBank() == 4000 || getBank() == 6000|| getBank() == 8000) {

					try {
						wait();//stop
						// synchronized은 원래 다른 스레드가 들어올 수 없지만 wait가 있으면 가능.
						// 하나의 스레드가 사용중이면 다른 스레드는 동기화 블럭에 들어올 수 없지만 wait()가 있으면 가능하다.
					} catch (Exception e) {

					}

				} else {
					notify();
				}
			}

		}

	}
	
}


public class Test9 {

	public static void main(String[] args) {
		MyThread9 ob = new MyThread9();
		
		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);
		
		t1.start();
		t2.start();
		
	}
	
}
