package com.score5;

import java.io.Serializable;

public class ScoreVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String birth;
	private int jumsu;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getJumsu() {
		return jumsu;
	}
	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
	public String toString(){
		return String.format("%6s %10s %4d", name, birth, jumsu);
		
	}
	
}	
