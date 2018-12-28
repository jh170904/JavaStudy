package com.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

//파일 복사프로그램
//원본 파일?:d:\\doc\\test.txt
//대상 파일?:d:\\doc\\abc.txt
//복사 성공

public class Test07 {

	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			int data;
			String str1, str2;
			
			System.out.print("원본파일경로?:");//	d:\\doc\\test.txt
			str1 =sc.next();
						
			System.out.print("대상파일경로?:");//	d:\\doc\\out2.txt
			str2 =sc.next();
			
			FileInputStream fis = new FileInputStream(str1); //파일읽기
			
			FileOutputStream fos = new FileOutputStream(str2);//파일생성
			
			while((data=fis.read())!=-1){//읽은 파일(fis)에 데이터가 있을 동안 실행

				fos.write(data);//fos에 해당 데이터를 써라
				fos.flush();
				
			}
			
			fis.close();
			fos.close();	
			System.out.println("복사성공!");
			
			sc.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
