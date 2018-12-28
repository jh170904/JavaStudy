package com.day15;

import java.io.FileOutputStream;

//FileOutputStream
//파일을 생성.
//A file output stream is an output stream for writing data to a File or to a FileDescriptor.

public class Test06 {

	public static void main(String[] args) {

		try {
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out.txt");
			int data;
			
			System.out.print("문자열 입력: ");
			
			while((data=System.in.read())!=-1){// System.in.read() 아스키코드로 읽음 
				fos.write(data);//입력시 어디가 끝인지 모름. ctrl+z로 종료
				fos.flush();
			}
			
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
