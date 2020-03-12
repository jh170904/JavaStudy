package com.day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

// 파일을 전송하고자 하는 클라이언트 클래 
// [클라이언트] fis 파일읽기 > oos 직렬화 >>> 전송 >>> [서버] ois 역직렬화 > fos파일생성
public class FileClientTest {

	public static void main(String[] args) {
		
		int port = 5555;
		String host = "127.0.0.1";					// 자신 ip를 써줘도 된다.
		
		Socket sc = null;		
		ObjectOutputStream oos = null;
		Scanner scn = new Scanner(System.in);
		String file;
		
		try {
			
			// 1. 전송할 파일경로를 입력 받는다.
			System.out.print("전송할 파일 경로명? :");	// d:\\doc\\test.txt
			file = scn.next();
			File f = new File(file);
			
			// 2. 파일 존재 여부 확인
			if(!f.exists()){
				System.out.println("파일이 없습니다.");
				System.exit(0);
			}
			
			// 3. 전송을 위한 소켓 및 스트림 생성
			sc = new Socket(host, port);
			oos = new ObjectOutputStream(sc.getOutputStream());
			oos.flush();
			
			// 전송하는 파일과 관련된 정보를 담는 클래스 객체 생성
			FileInfo info = new FileInfo();
			info.setCode(100);
			info.setData(f.getName().getBytes());//파일의 이름을 받을 때 byte단위로 받아야 함
			info.setSize((int)f.length());
			oos.writeObject(info);// 명시된 fileinfo 객체를 ObjectOutputStream 으로 작성한다. 네트워크를 통해 파일 저장한 것
			
			System.out.println(f.getName() + "파일 전송 시작!!");
			Thread.sleep(300);//한번에 내보내지 않고 중간에 휴식. 처리되는 과정을 확인하기 위함.
			
			// 4. 파일 내용 전송
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
			// 5. 파일 전송 종료
			fis.close();
			
			// 6. 파일 전송 종료를 알리기 위한 FileInfo 클래스 전송
			info = new FileInfo();//FileInfo 클래스 재할당 
			info.setCode(200);
			info.setData(f.getName().getBytes());
			info.setSize((int)f.length());		
			oos.writeObject(info);
			
			System.out.println(f.getName() + "파일 전송 종료!!");
			Thread.sleep(300);
			
			oos.close();
			scn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
