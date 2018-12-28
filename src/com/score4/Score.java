package com.score4;

public interface Score {
	public void input(); //입력
	public boolean searchHak(String hak); //학번 존재여부. 입력시 학번중복여부 확인해야함. 매개변수로 학번필요
	public void print();//출력
	public void update();//수정
	public void delete();//삭제
	public void findHak();//학번검색
	public void findName();//이름검색
}
