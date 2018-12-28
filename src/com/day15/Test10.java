package com.day15;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

//PrintStream

public class Test10 {

	public static void main(String[] args) {

		try {
			
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out1.txt");//파일생성
			
			PrintStream ps = new PrintStream(fos); //PrintStream은 기본생성자가 없음. 반드시 파일 위치 알려줘야 함
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("문자열입력?");
			
			String str;
			while((str=br.readLine())!=null){//br에 있는 데이터를 엔터 단위로 묶어서 String으로 읽어라. null이 나올 때까지
				ps.println(str);//ps 스트림에 출력
			}
			
			//사용한 파일은 항상 닫아주기
			ps.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
