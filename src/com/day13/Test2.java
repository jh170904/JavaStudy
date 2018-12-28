package com.day13;

import java.util.Hashtable;
import java.util.Iterator;

//Map<키, 값> 인터페이스
//list와 Map이 가장 많이 사용됨. 속도는 Map이 더 빠름(고유값이 존재, key).
//Hashtable : Vector와 동일
//HashMap : ArrayList와 동일
//키는 중복값을 가질 수 없다.(키는 Set이다.)
//키가 중복값을 가지면 마지막 값이 저장된다. 1 이순신, 1 홍길동 -> 입력 시 1 홍길동만 남음
// -> 키가 같으면 수정된다.
//Map은 Iterator가 없다.(Set의 Iterator를 빌려 쓴다)
//put(입력)
//get(출력)
public class Test2 {

	public static final String tel[] = {"111-111","222-222","333-333","111-111","444-444"}; //key
	public static final String name[] = {"배수지","박신혜","한지민","이효리","천송이"};		//value
	
	public static void main(String[] args) {

		Hashtable<String, String> h = new Hashtable<String, String>(); //Map중 Hashtable 객체 생성. 인터페이스. 맨처음 Hashtable -> Map으로 변경 가능
		for(int i=0; i<name.length;i++){
			h.put(tel[i], name[i]);
		}
		
		System.out.println(h);//Map은 출력시.. 컴퓨터에게 최적의 상태로... 자기맘대로 보여줌
		//중복된 키 값 111-111 이므로 이효리만 남음
		//-----------------------------------------------
		
		String str; 
		str = h.get("111-111"); //key를 주면 value를 반환
		System.out.println(str);
		
		//키가 존재하는지 검사
		if(h.containsKey("222-222")){
			System.out.println("222-222 존재");	
		}else{
			System.out.println("222-222 존재 안함");
		}
		
		//Value가 존재하는지 검사
		if(h.containsValue("박 신혜")){ //띄어쓰기 존재하면 못찾아냄
			System.out.println("있어요!");
		}else{
			System.out.println("없어요!");
		}
		
		//데이터삭제
		h.remove("222-222"); //키값을 매개변수로 사용. 해당 키값과 value를 삭제
		if(h.containsKey("222-222")){
			System.out.println("222-222 존재");	
		}else{
			System.out.println("222-222 존재 안함");
		}
		
		//키는 Set이며, Map의 Set은 중복을 허용하지 않는 자료구조이다.
		//Set은 Iterator가 존재하므로 Hashtable 또는 HashMap의 
		//keyset()메소드로 Iterator를 사용한다.
		
		Iterator<String> it = h.keySet().iterator(); //key의 자료형으로 작성
		//Set도 인터페이스
		
		while(it.hasNext()){
			String key = it.next();//key
			String value = h.get(key);//Map에 key값을 넣으면 value 반환
			System.out.println(key + ":" + value );

			
		}
		
		
	}

}
