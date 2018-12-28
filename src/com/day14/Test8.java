package com.day14;

class MyThread8 implements Runnable{
	
	private int bank = 10000;
	
	private int getBank(){//잔액확인메소드
		return bank;
	}
	
	private int drawMoney(int m){//잔액인출메소드
		bank -=m;//bank=bank-m;
		return m;
	}
	
	@Override
	public void run() {
		
		int money_need = 6000;//인출금액
		int money;//잔액
		String msg = "";
		
		try {
			
			//동기화블럭 t1 스레드가 들어오게되면 다른 스레드 절대 접근불가
			synchronized (this) {

				if (getBank() > money_need) {//잔고가 더 크면 진행
					
					Thread.yield();
					// A hint to the scheduler that the current thread is willing to yield its current use of a processor.
					// The scheduler is free to ignore this hint.
					// sleep 메소드처럼 다른 스레드에게 실행할 기회를 주기 위해 사용됨.
					// 우선권이 동일한 스레드에게 실행 기회 제공
					money = drawMoney(money_need);
				
				} else {
					money = 0;
					msg = ", 인출실패";
				}
			}
		
			System.out.println(Thread.currentThread().getName()+ msg +", 인출금액: " + money + ", 잔고: "+ getBank());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}

public class Test8 {

	public static void main(String[] args) {

		MyThread8 ob = new MyThread8();
		//Thread t1 = new Thread(new MyThread8()); 동일

		Thread t1 = new Thread(ob);
		Thread t2 = new Thread(ob);
		
		t1.start();
		t2.start();
		
		//스레드 t1,t2가 run을 점유하려고 진행하다보니 잔고가 -2000, -2000이 되는 경우 발생
		//동기화 블록으로 해결 synchronized(){}
		//wait() 메소드,  notify() 메소드 는 동기화 블록에서만 사용
	}

}
