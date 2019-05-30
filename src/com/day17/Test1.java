package com.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

/*
 * 프로토콜. 통신규약
 * TCP/IP : 원격 데이터를 주고 받을 때 사용. 인터넷의 기본 프로토콜이 됨
 * TCP:데이터를 보내는 역할(스트림 관리), IP: 전송 전/후 데이터 검증하는 역할
 * 
 * InterNIC : International Network Information Center.
 * InterNIC에서 다양한 도메인을 관리 com org edu net
 * 
 */
public class Test1 {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String host;
			
			System.out.print("호스트[www.naver.com]: ");//www.naver.com 도메인 www는 웹서버
			host = br.readLine();
			//InetAddress 이름 분해 작업을 해줌
			InetAddress ia = InetAddress.getByName(host); //This class represents an Internet Protocol (IP) address. IPv4-32bit, IPv6-128bit. 
			System.out.println("Ip주소: " + ia.getHostAddress());//DNS에 주소를 가져가면 ip와 host를 읽어옴
			System.out.println("호스트: " + ia.getHostName());
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
