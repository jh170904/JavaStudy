package com.day05;

import com.day06.Rect;

public class Test9 {

	public static void main(String[] args) {

		Rect usa = new Rect();//패키지가 달라서 import 시켜야함
		//usa.input();
		int a = usa.area();
		int l = usa.length();
		usa.print(a, l);
			
		//전역변수: 초기값 - 0 
		//지역변수: 초기값 - 쓰레기값 가지고 있음
	}

}
