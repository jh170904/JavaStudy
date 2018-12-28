package com.day15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//BufferedReader
public class Test09 {

	public static void main(String[] args) {
		
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));//InputStreamReader에 매개변수를 파일 할당 가능. 파일을 읽어서 br(버퍼)에 저장. 같은 패키지에 없다면 경로를 써줘야 함
			
			String str;

			//readLine()메소드의 리턴 값은 String. String 값이 없을 경우는 null에 해당
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
			
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
