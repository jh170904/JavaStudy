package com.day14;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//정해진 시간마다 특정 작업을 하고 싶을때

public class Test10 extends Thread{
	
	private int num = 10;
	
	public Test10(){
		
		TimerTask task = new TimerTask() {//익명의클래스
			
			@Override
			public void run() {
				//반복 실행할 작업
				num = 0;
			}
		};
		
		Timer t = new Timer();
		Calendar d = Calendar.getInstance();
		/*
		  매일 0시 0분 0초부터 하루에 한번씩 반복
		  d.add(Calendar.Date,1);
		  d.set(Calendar.Hour,0); 			//오후 1시는 13으로 표현. 0은 밤 12시. 1은 새벽 1시
		  d.set(Calendar.MINUTE,0);			//분
		  d.set(Calendar.SECOND,0);			//초
		  d.set(Calendar.MILLISECOND,0);	//밀리세컨
		  
		  t.schedule(task, d.getTime(),1000*60*60*24)//밀리세컨*초*분*시
		  
		 */
		t.schedule(task, d.getTime(), 5000);// 5000:interval(5초간격)으로 실행
		
	}
	
	@Override
	public void run() {
		while(true){
			
			System.out.println(num++);
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {

		//Test10 ob = new Test10();
		//ob.start();
		
		new Test10().start();//객체를 만들어서 한번만 실행하고 끝나면 됨. 메모리의 낭비를 줄일 수 있음.
		
		
	}

}
