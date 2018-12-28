package com.day15;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//InputStreamReader
//1byte Stream을 2byte Stream으로 변환해주는 Stream

public class Test03 {
	
	public static void main(String[] args) throws IOException{
		
		int data;
		System.out.print("문자열 입력: ");
		
		//InputStramReader : 브릿지클래스
		Reader rd = new InputStreamReader(System.in); //Reader: 읽어온 데이터를 잠깐 담아두는 클래스. Abstract class for reading character streams
		//Reader보다 BufferedReader가 더 빠름
		
		//rd에 더 이상 읽을게 없을 때까지 실행
		while((data=rd.read())!=-1){//read() : Reads a single character. data: 아스키코드값을 읽으므로 Integer 사용
			
			char ch = (char)data;
			System.out.print(ch);
			
		}
	}

}
