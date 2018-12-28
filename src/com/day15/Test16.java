package com.day15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//단순히 Buffer를 사용한 예제

public class Test16 {
	
	public final static int BUFFER_SIZE = 512;
	
	public static void main(String[] args) {
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out5.txt");
			
			//Buffer로 한번 더 감싸준 형태
			BufferedInputStream bis = new BufferedInputStream(fis);//버퍼로 된건 속도가 좀더 빠르기 때문에 fis, fos를 버퍼로 한번 더 감싸준 것
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int data, len=0;
			
			while((data=bis.read(buffer))!=-1){
				
				System.out.println("읽은 문자길이: " + data);
				len += data;//누적
				
				bos.write(buffer,0,data);//byte배열 buffer를 0~data까지 작성
				bos.flush();
			}
			
			System.out.println("읽어들인 전체길이: " + len);
			
			fis.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
