package com.day06;
//같은 패키지 안에 Rect 클래스가 있기 때문에 import 해줄 필요 없음
public class Test7 {
	
	public static void main(String[] args) {
/*		
		Class는 붕어빵 틀
		클래스를 만드는 이유는 재사용성. 객체(object)를 만드는 기능
		한 클래스안에 많은 내용이 있으면 메인메소드를 실행할 때 다 거친 후 진행하기 때문에 처리속도가 지연됨.
		그래서 메소드 마다 분리시킴. 파티션을 만드는 것이라고 생각
		'메소드명'은 무조건 모두 영소문자.
		
		지역변수 : 각 메소드안에 속하는 변수. 해당 메소드만 사용 가능. 
		전역변수 : instance 변수. 메모리에 올라가야만 사용할 수 있는 변수. 메모리를 올려놓는 것 = 객체 생성. 
					즉 객체 생성을 진행해야 사용가능한 변수. 클래스안 어디서든 사용가능. 값이 바뀌면 모든 메소드에서 같이 변경됨	
		
		접근지정자 : 4가지 public private protected default
		return : 메소드를 실행한 후의 반환값. return값이 없을 경우 void로 표현
		매개변수 : 8개 자료형 & string & void 가능
		메소드에서 매개변수를 원하면 반드시 사용해야 함. 입력하지 않거나 자료형이 다르거나 순서가 틀리면 오류 발생
		
*/
		Rect r1 = new Rect(); //같은 패키지 안에 있어서 import안함
		Rect r2 = new Rect();
		
		r1.input();
		int aa = r1.area();
		int ll = r1.length();
		r1.print(aa,ll);	//변수명은 클래스 생성시 이름과 달라도 문제없음. 자료형은 꼭 맞춰야함.
		
		r1.input();
		aa = r1.area();
		ll = r1.length();
		r1.print(aa,ll);	//매개변수명은 상관없음. 데이터 타입만 맞으면 됨
		
		r2.input();
		int area = r2.area();
		int length = r1.length();
		r2.print(area, length); 
	}

}
