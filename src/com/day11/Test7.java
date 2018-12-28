package com.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

interface FruitA{
	String Won = "원"; //앞에 public static final 생략
	public int getPrice();
	public String getName();
}

interface ItemFruit extends FruitA{ //인터페이스가 인터페이스를 상속받을 수 있다.
	public String getItems();	
}

class Orange implements ItemFruit{ //오버라이드 3개 해야 함. ItemFruit, FruitA 인터페이스의 메소드들.

	@Override
	public int getPrice() {
		return 1500;
	}

	@Override
	public String getName() {
		return "오렌지";
	}

	@Override
	public String getItems() {
		return "과일";
	}

}

class Apple implements ItemFruit{

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getName() {
		return "사과";
	}

	@Override
	public String getItems() {
		return "과일";
	}
		
}

public class Test7 {
	
	public void packing(ItemFruit ob){
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Test7 t = new Test7();
		System.out.print("1.오렌지 2.사과 : "); // 1 or 2 입력
		int ch = sc.nextInt();
		
		if(ch==1){
			t.packing(new Orange()); //오렌지클래스 객체를 생성해서 매개변수로 사용
		}else if(ch==2){
			t.packing(new Apple());
		}
		
		//new 가 매개변수로 들어가는 건 이미 많이 봤음 
		//BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
/*		
 * 인터페이스 예시
  		ItemFruit ob; 
		ob = new Orange();
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);

		ob = new Apple();
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
*/
		
/*
 * 자료형 예시
		int a;
		a = 10;
		System.out.println(a);
		
		int a;
		a = 20;
		System.out.println(b);	
		
*/
	
	}
}
