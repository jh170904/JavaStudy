package com.day13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test1 {

	public static void main(String[] args) {

		List<String> lists = new ArrayList<String>();
		
		lists.add("서울");
		lists.add("부산");
		lists.add("대구");
		
		Iterator<String> it = lists.iterator();
		while(it.hasNext()){
			String str= it.next();
			System.out.print(str+" ");
		}
		System.out.println();
		

		ListIterator<String> it2 = lists.listIterator();
		while(it2.hasNext()){
			System.out.print(it2.next() + " "); //위에 소스두줄이 하나로 표현 가능
		}
		System.out.println();
		
		//출력 2번 진행하더라도 뜨지 않음. 출력후 데이터는 NULL
		while(it2.hasNext()){
			System.out.print(it2.next() + " ");
		}
		System.out.println();
		
		//ListIterator<String> it3 = lists.listIterator();
		//역순으로 출력. hasPrevious 기능
		while(it2.hasPrevious()){
			System.out.println(it2.previous());
		}
		
		List<String> lists1 = new ArrayList<String>();
		lists1.addAll(lists); //collection을 add 할 수 있음
		lists1.add("인천");	//마지막에 추가 
		int n = lists1.indexOf("부산");//1
		lists1.add(n+1, "광주");//부산의 인덱스+1 위치에 광주를 삽입		
		
		for(String c : lists1){//확장for문으로 출력
			System.out.print(c + " ");
		}
		
		List<String> lists2 = new ArrayList<String>();
		lists2.add("자바프로그래머");
		lists2.add("프레임워크");
		lists2.add("스트럿츠");
		lists2.add("서블릿");
		lists2.add("스프링");
		
		String str;
		Iterator<String> it4 = lists2.iterator();
		
		while(it4.hasNext()){
			str = it4.next();
			if(str.startsWith("서")){ //리스트값과 시작하는단어가 동일한 것을 찾으라는 메소드
				System.out.println(str);
			}
		}
	}
}
