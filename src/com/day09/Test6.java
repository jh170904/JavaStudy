package com.day09;

//StringBuffer - 동기화지원O(builder보다 느림)
//StringBuilder - 동기화지원X(지원하지 않아 빠름)
//위에 두 클래스는 import하지 않아도 사용가능! -> 즉, 둘다 lang에 있다. 
//둘은 하는 역할이 다름
//동기화 지원 여부에 따라서 선택하여 사용하면 됨

public class Test6 {
	
	public void stringTime(){ //쓰레기값이 많이생김, a, aa, aaa, aaaa ... 모두 저장됨.
		
		System.out.println("stringTime...");
		//long start = System.currentTimeMillis(); //시스템의 초시간을 재겠다
		long start = System.nanoTime(); //시작시간 
		String str = "A";
		for(int i=1;i<50000;i++){
			str+="A";
		}
		long end = System.nanoTime(); //종료시간
		System.out.println("실행시간 : "+ (end-start));	

	}

	public void stringBufferTime(){ //누적시키는 것. append메소드 이용.
	
		System.out.println("stringBufferTime...");
		long start = System.nanoTime(); //시작시간 
		
		StringBuffer str = new StringBuffer("A");
		
		for(int i=1;i<50000;i++){
			str.append("A");
		}
		long end = System.nanoTime(); //종료시간
		System.out.println("실행시간 : "+ (end-start));	
	
	}
	
	public void stringBuilderTime(){
		System.out.println("stringBuilderTime...");
		long start = System.nanoTime(); //시작시간 
		
		StringBuilder str = new StringBuilder("A");
		
		for(int i=1;i<50000;i++){
			str.append("A");
		}
		long end = System.nanoTime(); //종료시간
		
		System.out.println("실행시간 : "+ (end-start));	
	}
	
	public static void main(String[] args) {
		
		Test6 ob = new Test6();
		ob.stringTime();
		ob.stringBufferTime();
		ob.stringBuilderTime();
	}

}
