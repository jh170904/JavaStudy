package com.score8;

public class ScoreDTO {//Data Transfer Object
/*
	기존에는 ScoreVO를 생성해서 
	ScoreVO를 리스트에 담아
	이 저장된 리시트를 파일에 담았다.
	
	DB를 배웠으니 접목하여 사용할 것.
	
	ScoreVO가 이제 Database 데이터를 전달하는 역할로 바뀜 -> DTO(Data Transfer Object)
	전달만 해주고 사라짐
*/	
	
	//DB에 존재하는 컬럼
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	//DB에 존재하지 않는 컬럼
	private int tot;
	private int avg;
	private int rank;
	
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
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString(){
		String str;
		str = String.format("%5s %8s %4d %4d %4d %4d %4d %4d ", 
				hak, name, kor, eng, mat, tot, avg, rank);
		return str;
	}
	
}
