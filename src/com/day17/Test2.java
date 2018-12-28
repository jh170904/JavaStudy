package com.day17;

import java.awt.Color;
import java.awt.Frame;

/*
 * AWT(Abstract Window Toolkit)
 * Window에 관한 모든 내용을 Frame이 가지고 있음. 반드시 생성자 만들어줘야 함. main문에는 코딩 별로 없음	
 * 윈도우 프로그램은 거의 C#, MFC에서 만들지만 AWT개념 알아두면 좋음
 * C#, Windows에서는 뜨는 창의 이름을 form이라고 부르고 자바에서는 frame.
 * Event를 기준으로 움직임
 */

public class Test2 extends Frame{
	
	public Test2(){
		
		//Frame 클래스를 상속 받아 사용
		setTitle("자바 윈도우");
		setSize(200, 300);
		setBackground(new Color(255, 255, 0));//배경색 노란색
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Test2();
		
	}

}
