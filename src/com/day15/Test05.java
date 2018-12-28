package com.day15;

import java.io.FileInputStream;

//FileInputStream
//파일을 찾아서 읽는 스트림

public class Test05 {

	public static void main(String[] args) {
		
		//Stream사용 시 반드시 try로 묶어줘야 함. 아니면 예외처리를 넣어 줘야 함
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test.txt"); 
			
			int data;
			while((data=fis.read())!=-1){//Reads a byte of data from this input stream. 
				
				//System.out.print((char)data);
				System.out.write(data);//엔터를 기준으로 내보냄. 
				System.out.flush();//엔터치지 않은 데이터도 내보냄
			}
			
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
