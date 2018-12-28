package com.day12;

import java.util.Iterator;
import java.util.Vector;

//Collections Framework(방법론) : 데이터를 관리하는 방법론
//종류가 굉장히 다양. 아래 두개가 가장 대표적. 
//둘은 인터페이스. 
//List(Vector, ArrayList) - ArrayList : 동기화지원안함. 그래서 속도 더 빠름
//Map(HashSet, HashTable, TreeSet)
//Collections은 처음부터 몇개 만들어라 정의안해도됨. 10개 만들어짐

//인터페이스는 객체를 생성할 수 없음. 인터페이스를 구현해서 사용하는 것일 뿐.

//List(I)
public class Test5 {

	public static void main(String[] args) {

		Vector v =new Vector(); //Collections Framework(벡터 포함)는 데이터 타입이 Object. 
		
		v.add("서울"); 		//String -> Object Upcast
		v.add(30);			//int -> Object Upcast
		v.add('c'); 		//char -> Object Upcast
		
		//모든 자료형 add가 가능함. -> Vector는 데이터 타입이 Object
		
		String str;
		Integer i;
		char c;
		
		str = (String) v.get(0); //Downcast Object를 String으로 형변환시켜서 str에 할당. 벡터도 0~ 인덱스 일렬번호로 저장됨
		System.out.println(str);
		i = (Integer) v.get(1);  //Downcast
		System.out.println(i);
		c = (char)v.get(2);	     //Downcast
		System.out.println(c);
		
		Iterator it = v.iterator();
		
		while(it.hasNext()){ //어떤 자료형이 들어갔는지 모르니까 downcast하는 반복문 작성
		//그래서 Collections 사용시 어떤 자료형인지 정해주는 이유.
		//eof, bof로 다음번에 데이터가 있는지 확인
			
			Object o = it.next();
			
			if(o instanceof String){
				str = (String)o;
				System.out.println();
			}else if(o instanceof Integer){
				i = (Integer)o;
				System.out.println(i);
			}else if(o instanceof Character){
				c = (char)o;
				System.out.println(c);
			}
			
		}
	}

}
