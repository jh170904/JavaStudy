package com.day15;

import java.io.IOException;
import java.io.OutputStream;

//기본 출력 스트림(out)

public class Test02 {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = System.out;
		//출력시 사용하는 가장 보편적인 스트림. 스트림안에 스트림을 넣을 수 있음
		//System.out은 1byte씩만 출력할 수 있음. 이걸 OutputStream 에 넣은 것.
		
		//buffer 생성
		byte[] b = new byte[3]; //배열에 데이터를 집어넣고 배열을 통채로 전송하는 방식 -> Buffer
		
		b[0] = 65;
		b[1] = 97;
		b[2] = 122;
		//저장시 아스키코드로 바뀜
		
		os.write(b);//OutputStream의 write메소드를 이용해서 한번에 출력
		
		os.close();
		
		//System.out이 닫혀서 메모리상에서 내려옴.
		//실행해도 아래줄이 보이지 않음.
		System.out.println("나보이냐?");
	}

}
