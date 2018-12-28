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
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest extends Frame implements ActionListener,Runnable{//다중인터페이스 
	
	private static final long serialVersionUID = 1L;
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	//서버는 서버소켓과 소켓 둘다 필요
	private ServerSocket ss = null;
	private Socket sc = null;
	//Socket에 담겨서 전달해야 하는 정보 : 서버ip, 내ip, data, port
	//Port번호 0~65535. 0~2000은 대부분 OS에서 사용

	//TCP-IP는 상대편의 IP를 반드시 받아오게 되어있음
	
	public ServerTest(){
		
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
		
		setTitle("채팅서버");
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ServerTest().serverStart();
	}
	
	public void serverStart(){
		
		try {
			ss = new ServerSocket(5555); //서버포트번호
			ta.setText("서버시작!!");
			
			//클라이언트가 접속을 해야 움직임. 접속전까지 딜레이 상태
			sc = ss.accept(); //accept(): 서버소켓과 소켓을 연결
			
			Thread th = new Thread(this);//채팅시 시작하라고 스레드 설정
			th.start();
			
		} catch (Exception e) {
			// TODO: handle exception
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
			PrintWriter pw = new PrintWriter(os,true);//여기서 true는 auto flush에 해당. flush는 enter를 만나야 함 
			pw.println("[서버]" + str);
			
			ta.append("\r\n [서버] " + str);
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {				//데이터를 보내다가 에러 발생시
			ta.append("\r\n 클라이언트와 연결 종료!!");
			sc = null;							//데이터 전송시 소켓만 사용하므로 소켓만 초기화
		}
	}
	
	@Override
	public void run() {
		
		//스레드는 채팅창 데이터를 받을 때 사용
		
		String str;
		String ip;
		
		try {
			
			if(sc==null){//소켓이 null이면 클라이언트가 접속을 안한 상태
				return;
			}
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			ip = sc.getInetAddress().getHostAddress();//client IP
			
			ta.append("\r\n["+ip+"] 접속!");//줄바꿈작업+사용자접속알림
			
			while((str=br.readLine())!=null){
				ta.append("\r\n" +str);
			}
			
		} catch (Exception e) {
			ta.append("\r\n 클라이언트 연결 종료!");
		
			//네트워크에서 소켓들 초기화 진행 하지않으면 쓰레기값 들어있음.  
			sc = null; 
			ss = null;
		}
	
	}

}
