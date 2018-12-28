package com.score4;

public class ScoreVO {

	//hak을 key로 한 map 사용할 것이므로 hak 선언안함
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() { //tot는 Getter만 있음
		return kor+eng+mat;
	}
	
	//원래 VO클래스에는 변수선언 + Getter/Setter만 쓰는 게 일반적
	@Override
	public String toString() {
		
		String str;
		str = String.format("%6s %4d %4d %4d %4d %5.1f", name, kor, eng, mat, getTot(), getTot()/3.0);
		
		return str;
	}
}
