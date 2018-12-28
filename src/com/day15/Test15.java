package com.day15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

//RandomAccessFile
//파일을 랜덤하게 읽고 쓸수 있는 클래스 
//RandomAccessFile클래스 생성시 mode옵션으로 '읽기 전용' 또는 '읽고 쓰기 가능'으로 설정 가능

public class Test15 {

	public static void main(String[] args) {
		
		try {
			
			//File.createTempFile(prefix, suffix)
			//- 환경 변수로 지정된 tmp 디렉토리에 자동으로 생성된다.

			File f = File.createTempFile("imsi", "tmp"); //(파일, 모드). 비어있는 임시파일 객체 생성 
			
			System.out.println(f.getName());
			
			f.deleteOnExit();//해당 메소드를 호출 하면 jvm이 종료 될때, 자동으로 임시파일이 삭제된다.
			
			FileOutputStream fos = new FileOutputStream(f);
			
			//파일 작성
			for(int i=0;i<100;i++){
				fos.write(i);
			}
			fos.close();
			
			RandomAccessFile raf = new RandomAccessFile(f, "rw"); //f의위치, read,write기능 가능
			
			for(int i=0;i<=100;i++){
				raf.seek(i);//찾아라
				System.out.println("raf.seek(" + i + "): "+raf.readByte());//읽어라. Reads a signed eight-bit value from this file.
			}
			
			raf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
