package com.day17;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// WindowListener 인터페이스. 윈도우폼에 관한 모든 이벤트 존재. 
// 단점: 사용하지 않는 메소드들도 모두 오버라이드 해야함
public class Test3 extends Frame implements WindowListener{
	
	public Test3(){
		
		setTitle("윈도우");
		setSize(200,300);
		setBackground(new Color(242,0,36));
		addWindowListener(this);//Listener. event가 발생하는지 지켜보고 있음. Test3 자기자신에게 이벤트를 알려야 하므로 this.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test3();
	}

	@Override
	public void windowActivated(WindowEvent e) {//창 활성화
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {//종료버튼 클릭시
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {//화면이 두개이상일 때 비활성화
	}

	@Override
	public void windowDeiconified(WindowEvent e) {//아이콘이 커졌을때
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {//창이 처음 열릴 때
	}

	
}
