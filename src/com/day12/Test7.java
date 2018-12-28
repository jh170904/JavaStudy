package com.day12;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test7 {
	
	private static final String city[] = {"서울","부산","대구","인천","광주","대전","울산"};

	public static void main(String[] args) {
		//Generic. 제너릭
		Vector<String> v = new Vector<String>();
		
		String str;
		
		System.out.println("벡터의 초기 용량: "+ v.capacity()); //초기용량 10.
		
		for(String c : city){ 
			v.add(c);
		}
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()){
			str = it.next();
			System.out.print(str + " ");
		}
		System.out.println();
		
		//데이터 변경
		v.set(0, "Seoul");
		v.set(1, "Busan");		
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();
	
		//-----------------------------------------
		//삽입
		
		v.insertElementAt("대한민국", 0);//맨앞에 대한민국을 삽입해라
		for(String s: v){
			System.out.print(s + " ");	
		}
		System.out.println();
		
		//-----------------------------------------
		//검색
		
		int index = v.indexOf("대구");
		if(index != -1){ //인덱스 번호가 있다면 해당 데이터가 존재.
			System.out.println("검색 성공! : " + index);
			System.out.println(v.get(index));
		}else{
			System.out.println("검색 실패!" + index);
		}
		
		//-----------------------------------------
		//오름차순 정렬(1~10, ㄱ~ㅎ)

		Collections.sort(v);
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();
		
		//-----------------------------------------
		//내림차순 정렬(10~1, ㅎ~ㄱ)

		Collections.sort(v, Collections.reverseOrder()); 
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();

		//-----------------------------------------
		//삭제
		
		v.remove("Busan"); //v.remove(7);과 동일
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();

		//-----------------------------------------
		//용량 증가
		
		System.out.println("벡터의 초기 용량: "+ v.capacity());	
		for(int i=1; i<=20; i++){
			v.add(Integer.toString(i));			
		}
		System.out.println("벡터의 용량: "+ v.capacity());	//알아서 용량이 늘어남.
		
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();
		
		//-----------------------------------------
		//특정 범위 삭제 : v.removeRange(5,20) 없어진 메소드
		for(int i=1; i<=10; i++){
			v.remove(5);
		}
	
		for(String s : v){
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("특정 범위 삭제 후 벡터의 용량: "+ v.capacity()); //용량은 자동으로 줄어들지 않음. 수동으로 줄여야함
		
		//-----------------------------------------
		//빈공간 삭제
		v.trimToSize(); //빈공간 23개가 삭제됨
		System.out.println("빈공간 삭제 후 벡터의 용량: "+ v.capacity()); 
		
		//-----------------------------------------
		//모든 데이터 지우기
		v.clear();
		System.out.println("데이터 갯수: "+ v.size()); //데이터를 지움 
		System.out.println("벡터의 용량: "+ v.capacity()); 	//데이터가 지워졌어도 용량은 안바뀜
		
		
	}
	
}
