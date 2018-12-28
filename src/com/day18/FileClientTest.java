package com.day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

//클라이언트 받은 파일 생성 
// [클라이언트] fis 파일읽기 > oos 직렬화 >>> 전송 >>> [서버] ois 역직렬화 > fos파일생성

public class FileClientTest {

	public static void main(String[] args) {
		
		int port = 5555;
		
		String host = "127.0.0.1";//자신 ip를 써줘도 됨
		Socket sc= null;
		
		ObjectOutputStream oos= null;
		
		Scanner scn = new Scanner(System.in);
		String file;
		
		try {
			
			System.out.print("전송할 파일 경로명? :");//d:\\doc\\test.txt
			file = scn.next();
			File f = new File(file);
			
			if(!f.exists()){
				System.out.println("파일이 없습니다.");
				System.exit(0);
			}
			
			sc = new Socket(host, port);
			oos = new ObjectOutputStream(sc.getOutputStream());
			oos.flush();
			
			//파일전송시작
			FileInfo info;

			info = new FileInfo();//FileInfo 클래스 객체 생성
			info.setCode(100);
			info.setData(f.getName().getBytes());//파일의 이름을 받을 때 byte단위로 받아야 함
			info.setSize((int)f.length());
			
			oos.writeObject(info);//네트워크를 통해 파일 저장한 것
			System.out.println(f.getName() + "파일 전송 시작!!");
			
			Thread.sleep(300);//한번에 내보내지 않고 중간에 휴식. jam 막기 위함
			
			//파일내용전송
			FileInputStream fis = new FileInputStream(f);//클라이언트에서는 읽어서 보내는게 필요
			
			int data = 0 ;
			byte[] buffer = new byte[1024];
			
			while((data=fis.read(buffer,0,1024))!=-1){//1024 -> buffer.length와 같음
				
				info = new FileInfo();
				
				info.setCode(110);
				info.setData(buffer);
				info.setSize(data);
				
				System.out.println(data + "bytes 전송중.....");
				oos.writeObject(info);//파일 object로 내보냄
				
				buffer = new byte[1024];//버퍼에 있는 내용이 사라짐. 사용 후 새로만듦
				Thread.sleep(300);
			}
			fis.close();
			
			//파일전송종료
			info = new FileInfo();//FileInfo 클래스 생성
			info.setCode(200);
			info.setData(f.getName().getBytes());//파일의 이름을 받을 때 byte단위로 받아야 함
			info.setSize((int)f.length());
			
			oos.writeObject(info);//네트워크를 통해 파일 저장한 것
			System.out.println(f.getName() + "파일 전송 종료!!");
			
			Thread.sleep(300);
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
