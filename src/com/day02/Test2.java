package com.day02;
import java.io.*;

class Test2 { 

	public static void main(String[] args) throws IOException {
	
		//밑변(width)과 높이(height)를 입력받아 삼각형의 면적(area)을 구하기

		//선언
		int width, height;
		double area;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		System.out.printf("밑변?");
		width = Integer.parseInt(br.readLine());

		System.out.printf("높이?");
		height = Integer.parseInt(br.readLine());

		//연산
		//area = (double)width * (double)height / 2 ; //강제 형변환 
		area = width * height / 2.0 ; //암시적 형변환 : 자바 실행시 소수점을 만나면 실수형으로 저장. 
		//출력
		System.out.printf("넓이: %g", area);


	}


}
