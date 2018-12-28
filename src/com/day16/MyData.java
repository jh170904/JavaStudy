package com.day16;

import java.io.Serializable;

// implements Serializable가 반드시 작성되어야 함.
// 선언해주지 않는다면 직렬화가 되지 않아 writeObject로 입력 불가능

public class MyData implements Serializable{//VO역할 하면 원래 GETTER, SETTER, 변수들만 있어야 하지만, 생성자 추가할 거임.

	private static final long serialVersionUID = 1L;
	
	private String name;
	private transient int age;
	private int score;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public MyData(String name,int age ,int score){//오버로딩된 생성자. 초기화
		this.name = name;
		this.score = score;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("%6s %4d %4d점",name,age,score);
	}
	
}
