package com.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiServerTest {

	// 클라이언트가 접속한 소켓을 담을 저장소
	private List<Socket> client = new ArrayList<Socket>();
	
	/**
	 * 소켓 생성 및 클라이언트의 요청을 기다린다. 소켓이 생성되면 WorkThread에 할당한다.
	 */
	public void serverStart(){		
		try (//포트 설정 및 서버 소켓 객체 생성.
			ServerSocket serverSocket = new ServerSocket(5555);) {		
			System.out.println("서버시작...");
			
			while(true){//몇 명이 접속할지 모르니 무한루프
				Socket socket = serverSocket.accept();//클라이언트가 접속되어있으면 진행, 소켓 생성. 접속을 안하면 딜레이 상태이므로 무한루프.
				WorkThread wt = new WorkThread(socket);//인원수만큼 소켓 생성하듯이, 스레드도 인원수만큼 만들어줌. 사람들이 말할때마다 스레드 번갈아 실행
				wt.start();//스레드 시작
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 메세지 송수신 작업을 수하는 스레드 객체 
	 */
	class WorkThread extends Thread{
		
		private Socket sc;				//소켓 초기화
		public WorkThread(Socket sc){	//오버로딩된 생성자
			this.sc = sc;
		}
		
		@Override
		public void run() {
			String ip = null;
			String msg = null;

			try {

				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				ip = sc.getInetAddress().getHostAddress();//ip와 호스트 읽어옴
				client.add(sc);//리스트에 사용자의 소켓을 저장
				
				//입장알림
				msg = ip +"]가 입장 했습니다!";
				for(Socket s: client){//사용자가 입장했다는 메세지를 모든 사용자에게 msg 알려야 함 
					if(s==sc){//꺼낸 소켓이 자신과 동일?
						continue;//이번만 통과
					}
					PrintWriter pw = new PrintWriter(s.getOutputStream(),true);//boolean autoFlush. 동일하지 않으면 출력
					pw.println(msg);
				}
				//서버에도 입장알림
				System.out.println(msg);
				
				//대화 : 스레드가 실행하기 때문에 절대 겹치지 않음
				while((msg=br.readLine())!=null){
					
					for(Socket s: client){//채팅시 자신을 제외한 사람들에게 보여야 함
						if(s==sc){//꺼낸 소켓이 자신과 동일?
							continue;//이번만 통과
						}
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);//boolean autoFlush
						pw.println(msg);
					}
					System.out.println(msg);//서버에도출력
				}
			
			} catch (Exception e) {
				
				//퇴장(연결끊김)
				msg = ip +"]가 퇴장 했습니다!";
				try {
					for(Socket s: client){
						if(s==sc){
							continue;
						}
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
					}
					System.out.println(msg);//서버에도출력
					sc =null;//퇴장했으니 소켓 초기화. 그래야 다음번에 연결 가능

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 어플리케이션이 구동되면 main문을 가장 먼저 찾아가게 되고 serverStart메소드을 실행한다. 
	 */
	public static void main(String[] args) {
		new MultiServerTest().serverStart();
	}

}
