package com.day18;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

//서버. 스트림 데이터 읽은 후 파일 생성
//직렬화된 데이터를 전송하므로 ObjectOutputStream, ObjectInputStream 필요(Serializable 필수)
//네트워크에서 데이터를 보낼 때는 getInputStream, getOutputStream 메소드 활용

public class FileServerTest {

	class WorkThread extends Thread{//내부클래스
		
		private Socket sc= null;

		public WorkThread(Socket sc){
			this.sc=sc;
		}
		
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

						if(info.getCode()==100){//100 : 파일전송 시작(파일명 전송)
							
							String str =new String(info.getData());
							fos = new FileOutputStream(str);//파일명
							
							System.out.println(str + "파일 전송 시작!!");
							
						}else if(info.getCode()==110){//110 : 파일 내용을 전송
							
							if(fos==null)
								break;//파일없으면 중지
							
							fos.write(info.getData(), 0 ,info.getSize());//파일을 내보냄. 0~사이즈만큼
							
							System.out.println(info.getSize() + "bytes 받는 중...");
						
						}else if(info.getCode()==200){//200 : 파일전송 종료(파일명 전송)
							
							if(fos==null)
								break;
							String str = new String(info.getData());//data에는 파일명 있음
							fos.close();
							System.out.println(str + "파일 전송 끝");
						}
					}
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void serverStart(){
		
		try {
			
			ServerSocket ss = new ServerSocket(5555);//소켓 객체 생성 후 포트설정
			System.out.println("파일 서버 시작");
			Socket sc = ss.accept();
			WorkThread wt = new WorkThread(sc);
			wt.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {

		new FileServerTest().serverStart();
	}

}
