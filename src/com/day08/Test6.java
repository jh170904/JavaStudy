package com.day08;

//Call By Value. 
//동일 변수값을 가진다.
//stack 영역의 데이터가 Heap영역으로 데이터 자체가 넘어감

//Call By Reference
//Heap영역에 있는 데이터를 복사할때 데이터자체가 복사되는게 아니라 주소가 복사되는 것
//static과 같은 역할을 함 
//동일 주소를 가진다. 주소를 서로 나누어 가짐
//이미 만들어진 것을 가져다 쓸 때 사용.  

class Test{
	public int x= 10;
	public void sub(int a){
		x += a; //x=x+a
	}	
}

public class Test6 {

	public static void main(String[] args) {
		Test ob = new Test();
		int a = 10;

		System.out.println("sub메소드 실행전 :" + ob.x);
		ob.sub(a);// Call by value 
		System.out.println("sub메소드 실행후 :" + ob.x);
		
		Test ob1;
		ob1 = ob; //Call by reference. ob의 주소값을 ob1에 넣어라. 주소값을 복사해서 같은 곳을 가리키므로 동일값 나옴
		
		System.out.println("ob.x:" + ob.x ); //20
		System.out.println("ob1.x:" + ob1.x ); //20
		
		//똑같은 위치인 걸 어떻게 아느냐. 값을 변경해서 다시 조회해보면 됨
		ob1.x = 100;
		System.out.println("ob.x:" + ob.x ); //100
		System.out.println("ob1.x:" + ob1.x ); //100
	}
	
}
