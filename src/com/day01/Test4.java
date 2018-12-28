package com.day01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//import java.io.*;

/*
	import는 C언어에서의 #include와 같다.
	C:\Program Files\Java\jdk1.8.0_191\src.zip\java package 위치를 알려줘야 해서 import하는 거라고 이해!
	import java.io.* - io패키지에 있는걸 모두 가져와. 메모리낭비. 되도록이면 하나씩 적어주는게 좋음
	io는 input과 output에 관련된 패키지
	이클립스 사용할 때 알아서 툴이 import 시켜줌. 굳이 외울 필요는 없음
*/

class Test4 {
	public static void main(String[] args) throws IOException {
/*	
	오류가 생겼을때 뺀다.
	throws 키워드는 실행시간에 예외가 발생했을 경우, 해당 예외를 직접처리하지 않고 다른 곳에서 처리하도록 예외를 던지겠다
*/

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
/*	
	BufferedReader 는 class. 
	System.in : 키보드로 입력한 1개의 문자 읽음.
	InputStreamReader : System.in을 통해서 읽은 문자를 2byte로 변경시킴. 10을 '1'과 '0'이 아니라 '10'으로 인식하게 해줌
	한쪽에서 들어온 데이터를 다른쪽으로 넘겨주는 역할을 하는게 브릿지클래스
	BufferedReader : 버퍼로 입력 받아 처리속도를 높임

	 -> 만약 이 세가지가 없었다면 일일히 클래스를 선언해놔야 사용가능. 이미 api에 등록되어 있다.	
	API : 사용설명서 개념. 여러 클래스와 메소드를 정리해놓음. 
	링크 : https://docs.oracle.com/javase/8/docs/api/
	
	java > javalang > 이 패키지안에 String, System 있음. 사용빈도가 높은 것들은 메모리에 무조건 올려놓음 
	매번 import 시키지않아도 바로 사용할 수 있도록!
*/

	int r;
	double area, length;

	System.out.println("반지름?"); //줄바꿈 prinfln. print는 줄바꿈없음. 
	r = Integer.parseInt(br.readLine()); 
/*	
	사용자가 입력하는 것을 읽어오는 명령어. 문자로 저장함. br.readLine();
	enter도 아스키값이므로 br에 들어있는 '10'과 enter값을 가져온다
	이걸 숫자형으로 변환하기 위해 사용하는 게 Integer.parseInt();
	클래스안엔 여러 method 존재. BufferedReader의 method 중 하나가 readLine 인 것.
*/
	area = r * r * 3.14f;  //자바는 실수형을 입력하면 double로 세팅이 됨. 지금은 area를 double로 선언해놔서 오류 안생김
	length = r * 2 * 3.14;
	
	System.out.printf("반지름: %d, 넓이: %g, 둘레: %g\n", 
		r, area, length);	//줄바꿈은 ',' 나 '+' 뒤에서 해야 이어서 인식됨

	}

}
