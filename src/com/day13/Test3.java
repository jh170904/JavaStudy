package com.day13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Test3 {

	public static void main(String[] args) {

		//Set : 중복을 허용하지 않는다.
		//Set이라는 인터페이스를 구현한 HashSet 클래스
		Set<String> s = new HashSet<String>(); 
		
		s.add("서울");
		s.add("부산");
		s.add("대구");
		
		System.out.println(s);
		Iterator<String> it = s.iterator();
		
		while(it.hasNext()){
			String str= it.next();
			System.out.print(str + " ");
		}
		System.out.println();
		
		//중복허용안함
		s.add("서울"); //중복값을 추가해도 덮어씌워짐.
		System.out.println(s); 	
		
		System.out.println("---------------------------");
		
		
		//Stack
		System.out.print("스택: ");
		Stack<String> st = new Stack<String>();
		
		//입력시 push, add 메소드 가능. push를 더 많이 사용. 스택에서 이 메소드들은 move의 개념
		st.push("서울");
		st.add("부산");
		st.push("대구");
		st.push("광주");
		
		//시작과 끝이 정해져있을땐 for, 끝을 모를땐 while, 한번은 무조건 실행해야되면 Do~while
		while(!st.empty()){ //stack이 비어있을때까지 반복 진행.(끝까지 진행해라
			System.out.print(st.pop()+ " "); //stack은 데이터를 꺼내게 되면 삭제됨
		}
		
		
		//출력한 데이터는 삭제됨
		while(!st.empty()){
			System.out.print(st.pop()+ " ");
		}
		
		System.out.println("\n------------------------------");
		
		//Queue 
		Queue<String> q = new LinkedList<String>();
		q.add("서울");
		q.offer("부산");
		q.offer("대구");
		q.offer("광주");
		
		System.out.print("Queue : ");
		while(q.peek()!=null){
			System.out.print(q.poll() + " ");
		}
		System.out.println("\n------------------------------");
		
		List<String> list1 = new LinkedList<String>();
		
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		list1.add("E");
		list1.add("F");
		list1.add("G");
		list1.add("H");
			
		List<String> list2 = new LinkedList<String>();
		
		list2.add("서울");
		list2.add("부산");
		list2.add("대구");
		
		list2.addAll(list1); //컬렉션안에 컬렉션을 집어 넣을 수 있다.
		
		System.out.print("LinkedList : ");
		for(String ss:list1){
			System.out.print(ss + " ");	
		}
		System.out.println();
		
		System.out.print("컬렉션에 컬렉션을 넣은 LinkedList : ");
		for(String ss:list2){
			System.out.print(ss + " ");	
		}		
		System.out.println("\n------------------------------");
		
		//범위삭제
		list2.subList(2, 5).clear();
		for(String ss:list2){
			System.out.print(ss + " ");	
		}
		System.out.println("\n------------------------------");
		
		String[] str = {"다","바","나","가","마","라"};
		System.out.print("기존배열: ");
		for(String ss : str){
			System.out.print(ss + " ");
		}
		System.out.println();
		
		//배열 정렬
		Arrays.sort(str);
		System.out.print("정렬된 배열: ");
		for(String ss : str){
			System.out.print(ss + " ");
		}
		System.out.println();
		
	}

}


/* 

범용적인 데이터는 리스트, key와 value를 구분해야할 때에는 map 사용

[List] 
동기화를 지원하냐에 따라 속도차이가 많이남. ArrayList : 동기화지원안함. 그래서 속도 더 빠름
List<저장할 자료형> lists = new ArrayList<저장할 자료형>();
List<저장할 자료형> lists = new Vector<저장할 자료형>();

ArrayList<저장할 자료형> lists = new ArrayList<저장할 자료형>();
Vector<저장할 자료형> lists = new Vector<저장할 자료형>();

**메소드
add : 추가
size : 요소갯수
remove(index) : 삭제
clear : 전체데이터 삭제
trimtoSize : 빈공간 삭제

Iterator<저장된 자료형> it = lists.iterator();
while(it.hasNext()){
	저장된자료형 value = it.next();
}

--------------------------------------------------------------------------------------------
[Map]

hashmap과 hashtable은 속도차이가 거의 나지 않음
Map<키자료형, 저장할자료형> map = new HashMap<키자료형, 저장할자료형>();
Map<키자료형, 저장할자료형> map = new Hashtable<키자료형, 저장할자료형>();

HashMap<키자료형, 저장할자료형> map = new HashMap<키자료형, 저장할자료형>();
Hashtable<키자료형, 저장할자료형> map = new Hashtable<키자료형, 저장할자료형>();

put(key,value) : 추가
remove : 삭제
clear : 전체삭제

Iterator<저장된 자료형> it = map.keySet().iterator();
while(it.hasNext()){
	키자료형 key = it.next();
	저장된자료형 value = map.get(key);
}

*/