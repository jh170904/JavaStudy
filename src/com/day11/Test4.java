package com.day11;

class SuperTest{
	
	public int a= 10, b= 20;
	
	public void write(){
		System.out.println("슈퍼클래스 write() 메소드....");
	}
	
	public int hap() {
		return a+b;
	}

}

class SubTest extends SuperTest{
	public int b=100, c=200;

	public void print() {
		System.out.println("서브클래스 print() 메소드....");
	}
	
	@Override
	public int hap() {
		return a+b+c;
	}
	
}

public class Test4 {

	public static void main(String[] args) {
		
		SubTest ob1 = new SubTest();
		System.out.println("b: "+ ob1.b); //100
		
		//SuperTest ob2 = (SuperTest)ob1; 명시적형변환
		SuperTest ob2 = ob1; //암시적형변환. upcast
		
		System.out.println("b: "+ ob2.b); //20
		
		System.out.println("합: "+ ob2.hap()); //310. 메소드는 무조건 자신거를 호출
		
		ob2.write();	
		
		//ob2.print(); ob2는 부모클래스이므로 사용불가. 내꺼는 내꺼다.(부모가 자식꺼를 사용할 수 없다.)
	}

}
