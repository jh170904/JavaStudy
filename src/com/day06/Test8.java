package com.day06;

import java.util.Scanner;

//하나의 클래스에서 여러 클래스를 만들 경우 public 쓰면 안됨
// Hap h = new Hap(); -> Class 생성 후 새로운 객체를 만들어야 원본이 그대로 유지. 반복 생성 가능. 이게 바로 재사용성

class Hap{
	
	int su, sum;
	public void input(){
		
		Scanner sc =new Scanner(System.in);	
		System.out.print("정수?");//100
		su=sc.nextInt();
		
	};
	
	public int cnt(){
		
		for(int i=1;i<=su;i++){
			sum+=i;		//sum을 초기화 안시켜도 오류안남. 전역변수는 0으로 초기화가 되어있음
		}	
		return sum;
	}
	
	public void print(int sum){
		
		System.out.println("1~"+su+ "까지의 합계: "+sum);
	
	}
}

public class Test8 {

	public static void main(String[] args) {
		Hap h = new Hap();
		h.input();
		int sum = h.cnt();
		h.print(sum);

	}

}
