package com.day17;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//WindowAdapter 클래스를 활용한 이벤트 인식
//1. 새로운 클래스를 만들어서 상속받은 후 사용 가능
//2. 익명의 내부클래스로 생성해서 사용해도 됨

public class Test4 extends Frame{

	public Test4(){
		
		setTitle("윈도우어답터");
		setSize(500,500);
		//addWindowListener(new MyWindowAdapter());//클래스를 가져옴. 객체 생성 후 바로 사용. 이름 필요없음
		
		//익명의 내부클래스를 만들어서 바로 오버라이딩 해도 됨
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {//윈도우 프레임에서 인식되는 이벤트들 7~10개 정도 있음
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test4();
	}
	
/*
	class MyWindowAdapter extends WindowAdapter {//내부클래스. (밀접한 관계시 이렇게 씀)

		//WindowAdapter를 상속받아 사용하면 내가 사용안하는 메소드를 일일히 정의할 필요 없음
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	
	}
*/	
	
}
