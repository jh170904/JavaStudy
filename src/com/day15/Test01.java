package com.day15;

import java.io.IOException;

//Stream. 종류가 몹시 다양. 파이프라인 개념
//기본 입력 스트림(in): 데이터를 전송할 때 그 사이즈는 1byte단위
public class Test01 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.print("문자열 입력[ctrl+z]: ");//abfdg123
		while((data=System.in.read())!=-1){ //System.in.read() 1byte씩 읽음
			char ch = (char)data;
			System.out.print(ch);
		}
		
	}

}
