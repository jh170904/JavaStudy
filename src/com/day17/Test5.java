package com.day17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test5 extends Frame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private TextField tf;	//텍스트 입력받는 부분
	private TextArea ta;	//텍스트 보이는 부분
	private Button btn;		//버튼

	public Test5(){
		
		tf = new TextField();
		ta = new TextArea();
		btn = new Button("확인");
		
		add(tf,BorderLayout.NORTH);		//BorderLayout 다섯개의 위치정보 가지고 있음
		add(ta,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		tf.addActionListener(this);		//텍스트 필드,버튼에서 이벤트 여부 확인
		btn.addActionListener(this);	//Listener는 특정 이벤트가 진행될 경우 ActionListener가 가지고 있는 actionPerformed메소드에 전달
		
		setTitle("윈도우");
		setSize(200, 300);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new Test5();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();//ActionEvent e 받아서 ob에 할당
		
		if(ob instanceof Button || ob instanceof TextField){
			String str = tf.getText();
			if(!str.equals("")){//가끔 equals 메소드로 인식 안될 때 있음 ->(!(str.equals("")||str==""))
				ta.append(str + "\r\n");
			}
			
			//텍스트필드 초기화 후 커서
			tf.setText("");
			tf.requestFocus();
			
		}
	}
	
}
