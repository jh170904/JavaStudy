package com.day18;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

//스트림 데이터 읽은 후 파일 생성을 진행하는 서버 클래스 
//직렬화된 데이터를 전송하므로 ObjectOutputStream, ObjectInputStream 필요(Serializable 필수)
//네트워크에서 데이터를 보낼 때는 getInputStream, getOutputStream 메소드 활용
public class FileServerTest {

	/**
	 * 파일을 수신하는 작업을 하는 스레드 객체 
	 */
	class WorkThread extends Thread {// 내부 클래스. 이너 클래스 
	
		// 멤버변수로 소켓을 가진다. 
		private Socket sc = null;

		// 생성자 
		public WorkThread(Socket sc){
			this.sc = sc;
		}
		
		// WorkThread.start() 시 작업을 수행한다.
		@Override
		public void run() {
		
			try {
				
				ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());//소켓의 InputStream을 넣어줌
				System.out.println(sc.getInetAddress().getAddress() + "접속....");
				FileOutputStream fos = null; //서버에서는 파일을 생성하기 위해서 FileOutputStream 필요
				Object ob = null;
				
				while((ob=ois.readObject())!=null){
					
					if(ob instanceof FileInfo){
						FileInfo info = (FileInfo)ob;//downcast

						// 100 : 파일전송 시작(파일명 전송)
						if (info.getCode()==100) {
							String str =new String(info.getData());
							fos = new FileOutputStream(str);//파일명
							
							System.out.println(str + "파일 전송 시작!!");
						
						}
						// 110 : 파일 내용을 전송
						else if (info.getCode()==110) {
							if(fos==null)
								break;//파일없으면 중지
							
							fos.write(info.getData(), 0 ,info.getSize());//파일을 내보냄. 0~사이즈만큼
							
							System.out.println(info.getSize() + "bytes 받는 중...");
						
						}
						// 200 : 파일전송 종료(파일명 전송)
						else if(info.getCode()==200) {
							if(fos==null)
								break;
							String str = new String(info.getData());//data에는 파일명 있음
							fos.close();
							System.out.println(str + "파일 전송 끝");
						}
					}
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 소켓 생성 및 클라이언트의 요청을 기다린다. 소켓이 생성되면 WorkThread에 할당한다.
	 */
	public void serverStart(){
	
		try (//포트 설정 및 서버 소켓 객체 생성.
			ServerSocket serverSocket = new ServerSocket(5555); 
			//클라이언트의 요청이 있는지 listen 하는 상태가 된다. 연결이 유지되는 동안 소켓을 생성한다.
			Socket socket = serverSocket.accept();) {
			
			System.out.println(">> 파일 서버 시작");
			WorkThread wt = new WorkThread(socket);
			wt.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 어플리케이션이 구동되면 main문을 가장 먼저 찾아가게 되고 serverStart메소드을 실행한다. 
	 */
	public static void main(String[] args) {
		new FileServerTest().serverStart();
	}

}