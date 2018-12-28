package com.score3;

public class ScoreVO {//VO : Value Object. 
					  //Data Transfer Object : DTO (DB에 저장할 경우 )
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	

	//public ScoreVO(){} 기본생성자 생략 가능	

/*	
	public ScoreVO(String hak, String name, int kor, int eng, int mat){ //오버라이드된 생성자. 변수초기화	
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
*/	
	//private로 변수를 설정할 땐 반드시 그 변수 하나당 Setter, Getter가 필요하다. 데이터를 입출력할 수 있도록.
	//마우스 우클릭 source > Generate Getter and Setter : 다 만들어줌
	
	//Getter, Setter
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
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
	
	//때로는 Getter, Setter중 하나만 필요할 수 있음
	public int getTot() {
		return kor+eng+mat;
	}
	
	
	@Override
		public String toString() {
		
			String str = String.format("%6s %6s %4d %4d %4d %4d %4f", hak, name, kor, eng, mat, getTot(), getTot()/3.0);
			
			return str;
	}

		
		

	
	
	
}
