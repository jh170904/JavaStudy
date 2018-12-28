package com.score1;

public class ScoreMain {

	public static void main(String[] args) {
		
		Score ob = new Score();//ob라는 이름으로 객체 생성
		
		ob.set();
		ob.input();
		ob.print();
		//ob.ranking(); // 조회안됨. 볼수없음. Score class내부가 아니기 때문 (접근제어자 private)	
		//ob1은 12byte공간(어떤 class간에 12byte 차지):heap + 자신(4byte):stack = 16byte
	
	}

}
