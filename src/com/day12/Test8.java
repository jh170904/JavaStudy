package com.day12;

import java.util.Vector;

class Test{
	String name;
	int age;
}

public class Test8 {

	public static void main(String[] args) {
		
		Vector<Test> v =new Vector<Test>(); //벡터의 자료형은 Object. 클래스도 들어갈 수 있다.
		//Collection 안에 Test라는 클래스를 집어 넣겠다. 배열에 클래스를 넣은 것과 마찬가지.
		
		Test ob;
		ob = new Test(); //여러 데이터를 넣을거라면 반드시 객체생성을 여러번 해줘야 함
		ob.name = "배수지";
		ob.age = 25;
		
		v.add(ob);
		
		ob = new Test(); //새로운 객체를 생성하지 않으면 동일주소값에 있는 데이터가 변경되버림.
		ob.name = "박신혜";
		ob.age = 27;
		
		v.add(ob);
		
		//Test ob가 가지고 있는 주소값은 한번 쓰고 필요가 없음. 벡터 v에 다 넣어놨음
		for(Test t: v){
			System.out.println(t.name + ":" + t.age);
		}	
	}
}
