package com.day07;

import java.util.Scanner;

class Circle{
	
	private int r; //instance변수. 중간에 값을 변경할 수 있으니까 외부에서 접근하지 못하게 접근지정자 작성. 
				   //private : within the class 
				   //아무것도 쓰지 않으면 public 
				   //정보의 은닉(캡슐화)
/*	
	변수초기화 방법 : '=' 이용해서 직접 대입 
					  .set()메소드 활용

	Circle ob = new Circle(); 객체생성 
	ob.setData(10); 매개변수 10으로 setData메소드를 실행해라.  
	우회해서 변수에 값을 넣는 것. private의 경우 반드시 이런 메소드가 있어야 한다.
	
	this : me. class 이름
	
	코딩하다보면 연결이 끊어진 garbage 데이터가 존재하는 경우가 있음
	VM에서 이런 클래스들을 삭제하는 garbage collector가 존재함
	그런데 메소드가 따로 없기 때문에 돌아다니다 자동으로 삭제되므로 하나도 삭제를 못하는 경우도 존재
	
*/	
	//초기화 메소드. 매개변수 이용. private 변수의 경우 이 메소드가 반드시 필요함 
	public void setData(int r){//setData(int r, Circle this) 내부적으로는 이렇게 처리됨
		
		this.r = r;	//전역변수 r, 지역변수 r 이름이 동일하면 구분못함
					//컴퓨터에서 전역변수로 인식하게 하기 위해 this사용. this는 me 와 같음. 자기자신. 클래스이름의 대명사.
					//혼동될 소지가 없으면 생략해도 됨
	}

	public double area(){//area(Circle this)
		return this.r*this.r*3.14;	
	}
	
	public void write(double a){//write(double a, Circle this)
		System.out.println("반지름:" + this.r);
		System.out.println("면적:" + a);
	}
	
}

public class Test2 {

	public static void main(String[] args) {

		Circle c1 = new Circle(); 
		//c1.r = 100; 캡슐화 되어있어 외부에서 접근할 수 없다. 실행하면 오류남
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름을 입력하세요: ");
		int r = sc.nextInt();
		c1.setData(r);				//c1.setData(r,c1); 내부적으로 c1클래스의 주소를 가져감 
		double result = c1.area();	//c1.area(c1); 매개변수 없으므로 c1클래스의 주소만 가져감 
		c1.write(result);			//c1.write(result,c1);
		
	}

}
