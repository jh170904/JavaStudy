package com.score8;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Score { //데이터 입력
//사용자가 입력하는 값을 저장할 클래스

	Scanner sc = new Scanner(System.in);
	ScoreDAO dao = new ScoreDAO();
	
	//입력
	public void insert(){
		
		try {			
			ScoreDTO dto = new ScoreDTO();//사용자 입력데이터를 담을 dto 객체 생성
			
			System.out.print("학번? ");
			dto.setHak(sc.next());
			
			System.out.print("이름? ");
			dto.setName(sc.next());
			
			System.out.print("국어? ");
			dto.setKor(sc.nextInt());
			
			System.out.print("영어? ");
			dto.setEng(sc.nextInt());
			
			System.out.print("수학? ");
			dto.setMat(sc.nextInt());
			
			//DAO에 입력된 값(dto)을 전달해서 쿼리 실행
			int result = dao.insertData(dto);
			
			if(result!=0){
				System.out.println("추가 성공!");
			}else{
				System.out.println("추가 실패!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//수정
	public void update(){
		
		try {
			ScoreDTO dto = new ScoreDTO();
			
			System.out.print("학번? ");
			dto.setHak(sc.next());
			
			System.out.print("국어? ");
			dto.setKor(sc.nextInt());
			
			System.out.print("영어? ");
			dto.setEng(sc.nextInt());
			
			System.out.print("수학? ");
			dto.setMat(sc.nextInt());
			
			int result = dao.updateData(dto);
			
			if(result!=0){
				System.out.println("수정 성공!");
			}else{
				System.out.println("수정 실패!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//삭제
	public void delete(){
		
		try {
			
			String delhak;
			System.out.print("삭제할 학번? ");
			delhak = sc.next();
			
			int result = dao.deleteData(delhak);
			
			if(result!=0){
				System.out.println("삭제 성공!");
			}else{
				System.out.println("삭제 실패!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//전체출력
	public void selectAll(){
		
		List<ScoreDTO> lists = dao.getList(); //리스트값이 반환되면 lists에 저장
		
		Iterator<ScoreDTO> it = lists.iterator();
		
		//lists 출력
		while(it.hasNext()){
			ScoreDTO dto = it.next();
			System.out.println(dto.toString());
		}
	}
	
	//이름검색
	public void searchName(){
		try {
			System.out.print("검색할 이름? : ");
			String searchName = sc.next();
			
			List<ScoreDTO> lists = dao.getList(searchName); 
		
			Iterator<ScoreDTO> it = lists.iterator();
			
			//lists 출력
			while(it.hasNext()){
				ScoreDTO dto = it.next();
				System.out.println(dto.toString());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//학번검색
	public void searchHak(){
		try {
			
			System.out.print("검색할 학번? : ");
			String searchHak = sc.next();
			
			ScoreDTO dto = dao.searchHak(searchHak);
			
			if(dto!=null){
				System.out.println(dto.toString());
			}
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
