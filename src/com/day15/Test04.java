package com.day15;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

//OutputStreamWriter
//1byte Stream을 2byte Stream으로 변환 해주는 Stream

public class Test04 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.print("문자열 입력: ");
		Reader rd = new InputStreamReader(System.in);
		
		Writer wr = new OutputStreamWriter(System.out); //so를 osw로 감싸고 osw를 w로 감싼 것.
		
		while((data=rd.read())!=-1){
		
			wr.write(data); //write(): Writes a single character.
			wr.flush(); //이 메소드가 없을 경우 버퍼가 꽉 차지않으면 내보내지 않음.
		
		}
		
	}

}
