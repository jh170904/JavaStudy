package com.day18;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTest extends Frame implements ActionListener,Runnable{//다중인터페이스 

	private static final long serialVersionUID = 1L;
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	//클라이언트는 소켓만 필요
	private Socket sc = null;
	private int port = 5555;
	private String host="192.168.16.16";//127.0.0.1(me, loopback주소, 네트워크에서 자기자신)
	
	public ClientTest(){
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		
		//텍스트입력창에 리스너
		tf.addActionListener(this);
		
		//종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setTitle("채팅클라이언트");
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ClientTest().connect();
	}

	public void connect(){

		try {
			sc = new Socket(host, port);
			Thread th = new Thread(this);//채팅시 시작하라고 스레드 설정
			th.start();
			
		} catch (Exception e) {
			ta.append("서버가 죽어있다!!");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//채팅창 데이터를 보낼 때 사용
		String str = tf.getText();
		if(str.trim().equals("")){//공백제거 후 문자열 값이 null이면 보내지마라
			return;
		}
		
		if(sc==null){
			return;
		}
		
		try {
			OutputStream os = sc.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);//여기서 true는 auto flush에 해당
			pw.println("[클라이언트]" + str);
			
			ta.append("\r\n[클라이언트]" + str);
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {				//데이터를 보내다가 에러 발생시
			ta.append("\r\n 서버와 연결 종료!!");
			sc = null;							//클라이언트는 소켓만 사용. 소켓만 초기화
		}
	}
	
	@Override
	public void run() {
		
		//스레드는 채팅창 데이터를 받을 때 사용
		String str;
		try {
			
			if(sc==null){//소켓이 null이면 클라이언트가 접속을 안한 상태
				return;
			}
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			ta.append("\r\n 접속!");//줄바꿈작업+사용자접속알림
			
			while((str=br.readLine())!=null){
				ta.append("\r\n" +str);
			}
		} catch (Exception e) {
			ta.append("\r\n 서버 연결 종료!");
			
			//소켓 초기화
			sc = null; 
		}
	
	}

}
