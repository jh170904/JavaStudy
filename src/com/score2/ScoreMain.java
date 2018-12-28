package com.score2;

public class ScoreMain {

	public static void main(String[] args) {
		
		ScoreImpl ob = new ScoreImpl();
		//Score ob = new ScoreImpl(); 이거도 가능. 상위클래스인 Score에 upcast
		ob.set();
		ob.input();
		ob.print();
		
	}

}
