package com.day09;

//String 
//String은 class이다.(자료형이 아니다.)
//다만, String을 자료형처럼 사용하는 이유는 저장하는 양은 방대하고 사용빈도가 높기 때문
//stack영역에 저장할 수 없고 heap영역에 저장해야 함 -> 그러다보니 class여야함 
//그런데 사용빈도가 높다보니 new 쓰면 번거로움 -> 그래서 자료형모양새 처럼 씀

//String은 불변의 법칙을 가지고 있다.
//String은 equals로 비교한다.

public class Test5 {

	public static void main(String[] args) {
		
		String ob1 = "Seoul"; //heap영역에 "Seoul"이 저장됨
		String ob2 = "Seoul"; //Call by reference
		String ob3 = new String("Seoul"); //사용빈도가 높다보니 이렇게 쓰기 어려움
		
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); //주소를 비교하면 false가 나와야하는데 true가 나옴
		//ob1, ob2 객체 생성시 new를 사용한게 아니기 때문에 Call by reference. 주소를 나눠가짐
		
		System.out.println("ob1 == ob2 : " + (ob1 == ob3)); //false
		//new를 통해 객체 생성, 무조건 heap영역에 새로운 메모리 할당. 주소값 상이하므로 false나옴
		
		System.out.println("ob1.equals(ob3) : " + ob1.equals(ob3)); //true
		//String은 클래스지만 자료형의 흉내를 내야함. 
		//ob1의 주소를 찾아가서의 값과 ob3의 주소를 찾아가서의 값을 비교해야 함
		//object.equals() : 이 메소드는 주소값 비교. 
		//object의 equals 메소드를 쓴게 아니라 String의 equals 메소드를 사용 (override : 자식클래스에서 메소드재정의) 
		
		ob2 = "korea"; //새롭게 메모리 할당함
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));	//false
		
		ob2 = "japan"; //korea와는 다르게 또 새로운 메모리 할당함
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));	//false
		//이게 바로 String 불변의 법칙
		
		ob2 = "Seoul"; //이미 Seoul을 할당해둔 게 있으니 그 주소로 저장
		System.out.println("ob1 == ob2 : " + (ob1 == ob2));	//True		
		//쓰레기값이 굉장히 많이 남아있다. 
		//일반적으로 많은 문자열을 입력할 경우 사용하는게 따로 있음
		
		System.out.println(ob1); //hashcode가 아닌 Seoul이 나옴
		System.out.println(ob1.toString()); //Seoul. override함. String의 toString()메소드 사용
		
		//String을 보조해주는 클래스 2개 존재 -> Test6
		
	}

}
