package com.day10;
//Singleton
//객체를 계속해서 생성하는 것이 아니라
//하나만 생성하고 공유해 사용하는 방법이다.
//Static, Call by reference 
//이 구조를 갖는 객체를 singleton 객체라고 함.
class Sing{
	
	private static Sing ob; //클래스의 초기값은 null. 이 상태에서는 null. static으로 만들었으므로 바로 메모리 할당.
	
	public static Sing getInstance(){ //반환값이 자기자신. Call by reference 
		if(ob==null){ 
			ob=new Sing();
		}
		return ob;
	}

}

public class Test6 {

	public static void main(String[] args) {
		
		Sing ob1 = Sing.getInstance(); //static변수. getInstance 메소드 사용해서 생성
		Sing ob2 = Sing.getInstance(); 
		//Call by Reference
		//주소를 서로 나눠씀. ob, ob1, ob2 모두 갖은 주소 가지고 있음. static 기능을 이용
		//Singleton: static, call by reference와 이 구조를 모두 알아야 사용 가능		
		if(ob1 == ob2){
			System.out.println("동일객체");
		}else{
			System.out.println("다른객체");
		}
		
	}

}
