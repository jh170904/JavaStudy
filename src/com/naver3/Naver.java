package com.naver3;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//import oracle.jdbc.internal.OracleTypes;

public class Naver {
	
	Scanner sc = new Scanner(System.in);
	NaverDAO dao = new NaverDAO();
	MyAuthenticator my = new MyAuthenticator();
	
	//1.INSERT 회원가입
	public void input(){
		
		try {
			String id, tel; 
			String gen;
			NaverDTO dto = new NaverDTO();
			System.out.print("id를 입력하세요. ");
			id = sc.next();
			my.inputFormat(id);
			dto.setId(id);
			
			System.out.print("PW를 입력하세요. ");
			dto.setPw(sc.next());
			
			System.out.print("Name를 입력하세요. ");
			dto.setName(sc.next());
			
			System.out.print("성별을 입력하세요. [남자/여자] : ");
			gen = sc.next();
			my.inputFormatGender(gen);
			dto.setGender(gen);
			
			System.out.print("생년월일을 입력하세요. ");
			dto.setBirth(sc.next());
			
			System.out.print("email를 입력하세요. ");
			dto.setEmail(sc.next());
			
			System.out.print("tel를 입력하세요. ※전화번호 입력 형식은 [XXX-XXXX-XXXX]입니다. ");
			tel = sc.next();
			my.inputFormatTel(tel);
			dto.setTel(tel);
			
			int result = dao.insertData(dto);
			
			if(result!=0){
				System.out.println("회원가입이 완료되었습니다!");
				
				System.out.println(dto.toString());
			}else{
				System.out.println("회원가입이 실패하였습니다!");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	//2.UPDATE 회원정보수정
	public void update(){
		try {
			NaverDTO dto = new NaverDTO();
			System.out.print("id를 입력하세요");
			dto.setId(sc.next());
			
			System.out.print("PW를 입력하세요");
			dto.setPw(sc.next());
			
			System.out.print("Name를 입력하세요");
			dto.setName(sc.next());
			
			System.out.print("성별을 입력하세요");
			dto.setGender(sc.next());
			
			System.out.print("생년월일을 입력하세요");
			dto.setBirth(sc.next());
			
			System.out.print("email를 입력하세요");
			dto.setEmail(sc.next());
			
			System.out.print("tel를 입력하세요");
			dto.setTel(sc.next());
			
			int result = dao.updateData(dto);
			
			if(result!=0){
				System.out.println("회원정보 수정이 완료되었습니다!");
				
				System.out.println(dto.toString());
			}else{
				System.out.println("회원정보 수정이 실패하였습니다!");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}	
	//3.DELETE 회원탈퇴
	public void delete(){
		try {
			
			String delId, delPw;
			System.out.print("탈퇴할 아이디를 입력하세요? ");
			delId = sc.next();
			System.out.print("비밀번호를 입력하세요? ");
			delPw = sc.next();
			
			int result = dao.deleteData(delId,delPw);
			
			if(result!=0){
				System.out.println("성공적으로 탈퇴하였습니다!");
			}else{
				System.out.println("탈퇴 실패");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}	
	//4.SELECTALL 회원전체출력
	public void print(){
		try {
			List<NaverDTO> lists = dao.getList();
			Iterator<NaverDTO> it = lists.iterator();
			//lists 출력
			while(it.hasNext()){
				NaverDTO dto = it.next();
				System.out.println(dto.toString());
			}			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		
	}
	//5.SEARCHID 아이디검색
	public void searchId(){
		try {
			String findId, findPw;
			System.out.print("검색할 아이디를 입력하세요? ");
			findId = sc.next();
			System.out.print("비밀번호를 입력하세요? ");
			findPw = sc.next();
			
			NaverDTO dto = dao.searchID(findId, findPw);
			
			if(dto!=null){
				System.out.println(dto.toString());
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
	


