package com.day18;

import java.io.Serializable;

//직렬화 반드시 필요

public class FileInfo implements Serializable{

	/*	
	code(임의로 설정)
	100 : 파일전송 시작(파일명 전송)
	110 : 파일 내용을 전송
	200 : 파일전송 종료(파일명 전송)
	size : 한번에 전송하는 크기
	data : 내용
	*/	
	
	private int code;
	private int size;
	private byte[] data = new byte[1024];//한번에 전송가능한 데이터의 양은 1024byte로 설정
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	

}
