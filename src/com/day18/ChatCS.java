package com.day18;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//UDP(근거리 통신망에서 사용. 프로토콜)
//인트라넷 IP
//IP:32bit 주소체제
//A,B,C class 
//D class(224.0.0.0 ~ 239.255.255.255): IP 똑같이 세팅해도 충돌안남. 인터넷연결x이기 때문
public class ChatCS extends Frame implements Runnable,ActionListener{

	private static final long serialVersionUID = 1L;
	private MulticastSocket ms = null;
	private InetAddress xGroup = null;
	
	private String host = "230.0.0.1";
	private int port = 7777;
	private String userName = "사용자이름";
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	//DatagramSocket : UDP로 데이터그램 패킷을 전송하거나 수신
	//DatagramPacket : UDP를 이용하여 전송될 수 있는 데이터
	//MulticastSocket : 다수의 클라이언트에 데이터그램 전송	
	//MulticastSocket : 서버에서 파일이나 데이터베이스에서 정보를 특정위치에 내려주면 클라이언트가 그 쪽으로 접속해서 받아감
	
	/**
	 * 기본생성자를 통해 채팅할 때의 틀을 만든다.
	 */
	public ChatCS(){
		
		ta.setEditable(false);//수정 불가능.읽기 가능
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setTitle("그룹채팅");
		setSize(400,400);
		setVisible(true);
		tf.requestFocus();
	}
	
	/**
	 * 동일한 아이피와 포트번호로 접속한 사용자들을 모은다. 
	 */
	public void setup(){
		
		try {
			xGroup = InetAddress.getByName(host);//DNS로 가서 IP주소를 받아 xGroup에 할당 
			ms = new MulticastSocket(port);
			
			//특정 그룹에 포함
			ms.joinGroup(xGroup);//230.0.0.1 ip를 쓰면서 포트번호 7777을 사용한 사람을 모음
			
			Thread th = new Thread(this);
			th.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 연결 종료 
	 */
	public void disConnection(){
		
		try {
			ms.leaveGroup(xGroup);//그룹에서 나오게 연결 끊음
			ms.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 어플리케이션이 구동되면 main문을 가장 먼저 찾아가게 되고 챗팅 셋업을 시작한다. 
	 */
	public static void main(String[] args) {
		new ChatCS().setup();
	}

	
	/**
	 * 메세지 전송한다.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = tf.getText().trim();//읽어오면서 공백제거
		
		if(str.equals("")){
			return; //보낼 메세지가 없으면 중단한다.
		}
		
		byte[] buffer = (userName+"]"+str).getBytes();//문자열이므로 배열 buffer에 넣기위해 형변환
		
		try {
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, xGroup, port);//버퍼에 있는 내용을 그 길이만큼 xGroup(host), port로 전송
			ms.send(dp);
			tf.requestFocus();
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			System.out.println(e.toString());
		}
	}

	/**
	 * 메세지를 수신한다.
	 */
	@Override
	public void run() {
		try {
			//사용자의 요청이 있기전까지 채팅이 유지되므로 무한 루프. 
			while(true){
				byte[] buffer = new byte[512];
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				ms.receive(dp);
				String str = new String(dp.getData()).trim();
				ta.append(str + "\r\n");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			disConnection();//수신 중 exception 발생해서 연결 종료
		}
	}

}
