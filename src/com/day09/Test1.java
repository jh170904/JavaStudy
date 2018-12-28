package com.day09;

// 모든 생성자안에는 super()가 생략되어 있다.
// A class - B class - C class 부모-자식 관계일 때
// 전혀 상관 없는 별도의 D class에서 C class의 객체를 생성할때 기본생성자안에있는 super를 통해
// 부모클래스의 메모리를 먼저 할당받은 뒤 마지막에 자식클래스 생성.
// 이때 최상위에 있는 A class의 부모클래스는? Object .
// java에서 가장 큰 자료형 = Object . 무엇이든지 넣을 수 있다. 자동으로 옮길 경우에는 무조건 object로 옮김. 제일 크니까.

class Test{
	
	private String title;
	protected int area;
	
	//public Test(){}//기본생성자
	
	public Test(String title){ //오버로딩된 생성자
		this.title = title;
	}
	
	public void print(){
		System.out.println(title + " : " + area);
		
	}
}
class Rect extends Test{ //에러발생. 
	//기본생성자 생략되어있음. 
	//이 기본생성자안에는 super(); 포함
	//부모클래스의 기본생성자를 생략하게 되면, 사용하지 않겠다는 의미. 
	//자식클래스에서 부모클래스의 기본생성자를 사용못해서 오류
	
	private int w,h;
	public Rect(int w, int h){
		
		//default값은 기본생성자임 super(); 
		//-> 그런데 부모클래스에 기본생성자를 삭제했으므로 오버로딩된 생성자를 통해 객체 생성해야함
		super("사각형"); //super에 매개변수를 할당하면 오류 사라짐. 부모클래스의 오버로딩된 생성자를 호출
		//부모클래스가 먼저 만들어져야 자식클래스가 생성 가능
		this.w =w;
		this.h =h;	
		//super("사각형"); 밑에 쓰면 오류남. 부모클래스 없는데 매개변수를 입력받아 처리 불가능. 두번입력도 불가능
	}
	
	public void rectArea(){
		area=w*h; //부모클래스 생성된 상태이므로 부모클래스의 변수 사용 가능		
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Rect ob = new Rect(10,20); 
		ob.rectArea();
		ob.print(); //부모클래스에서 가져다 씀 

	}

}
