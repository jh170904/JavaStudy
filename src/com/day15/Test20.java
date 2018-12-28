package com.day15;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

//StringReader
//StringWriter

//StringBuffer,StringBuilder가 이미 있어서 많이는 안씀 

public class Test20 {

	public static void main(String[] args) throws IOException {

		int ch;
		String str = "Hello!!....";
		
		StringReader sr = new StringReader(str);
		StringWriter sw = new StringWriter();
		
		while((ch=sr.read())!=-1){
			sw.write(ch);
		}
		
		System.out.println(sw.toString());	//문자 바로 출력
		StringBuffer sb = sw.getBuffer();	//문자 버퍼에 저장 후 출력
		System.out.println(sb.toString());
		
	}

}
