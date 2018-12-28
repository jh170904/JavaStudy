package com.day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//FileWriter
//출력할 유니코드 문자열을 시스템에 맞는 디폴트 문자 인코딩의 바이트로 변환해서 파일에 저장.

//BufferedWriter
//다른 출력 스트림을 생성자의 인자로 받아 생성하며
//문자를 버퍼링 하는것에 따라 문자.배열 또는 스트링을 문자 형태로 출력한다.
// -> 문자/바이트 스트림을 버퍼로 출력한다.

public class Test17 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		FileWriter fw = new FileWriter("d:\\doc\\out6.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String str;
		
		System.out.println("문자열 입력: ");
		
		while((str=br.readLine())!=null){
			bw.write(str);
			bw.newLine();//str + "\r\n"(엔터)
		}
		
		bw.close();
		fw.close();
		
	}

}
