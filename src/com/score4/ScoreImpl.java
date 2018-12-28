package com.score4;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreImpl implements Score {

	// private Map<String, ScoreVO> hMap = new HashMap<String, ScoreVO>();
	// 데이터가 컴퓨터마음대로 순서섞임
	private Map<String, ScoreVO> hMap = new TreeMap<String, ScoreVO>(); // 데이터가 들어간 순서대로 나옴
																		
	Scanner sc = new Scanner(System.in);
	String hak; //key 로 사용할 것 

	@Override
	public void input() {
		System.out.print("학번?");
		hak = sc.next();

		if (searchHak(hak)) {
			System.out.println("학번이 존재합니다.");
			return; // ScoreVO 객체생성 라인 이 실행되지 않고 input메소드만 종료
		}

		ScoreVO vo = new ScoreVO(); // 새로운 ScoreVO 객체생성

		System.out.print("이름");
		vo.setName(sc.next());
		System.out.print("국어");
		vo.setKor(sc.nextInt());
		System.out.print("영어");
		vo.setEng(sc.nextInt());
		System.out.print("수학");
		vo.setMat(sc.nextInt());

		hMap.put(hak, vo); //< key,value > ->Map에 추가
		System.out.println("추가 성공!!");
	}

	@Override
	public boolean searchHak(String hak) {

		if (hMap.containsKey(hak)) {// key가 있으면
			return true;
		}
		return false;

		// return hMap.containsKey(hak); //key값 존재 -> T, 없으면 -> F. 한줄로 표현 가능
	}

	@Override
	public void print() {
		Iterator<String> it = hMap.keySet().iterator();

		System.out.println();

		while (it.hasNext()) {
			String key = it.next();
			ScoreVO vo = hMap.get(key);

			System.out.println(key + " " + vo.toString());
		}
	}

	@Override
	public void update() {

		System.out.print("이름, 점수를 수정할 학번?");
		hak = sc.next();

		if (!searchHak(hak)) {
			
			System.out.println("입력되지 않은 학번입니다.");
			return;
		}
		
			String key = hak;
			
			ScoreVO vo1 = hMap.get(key); 
			String preName = vo1.getName();
			
			vo1.setName(preName); //이름을 기존값대로 넣어주지 않으면 NULL값이 설정되게 됨	
			
			System.out.print("국어");
			vo1.setKor(sc.nextInt());
			System.out.print("영어");
			vo1.setEng(sc.nextInt());
			System.out.print("수학");
			vo1.setMat(sc.nextInt());

			hMap.put(key, vo1);
			System.out.println("수정 성공!");
	}

	@Override
	public void delete() {

		String del;
		System.out.print("삭제할 학번?");
		del = sc.next();

		if (hMap.containsKey(del)) {
			hMap.remove(del);
			System.out.println("삭제완료");
		} else {
			System.out.println("해당 학번 없음");
		}

	}

	@Override
	public void findHak() {

		System.out.print("검색하고 싶은 학번?");
		hak = sc.next();
		
		if (hMap.containsKey(hak)) {
		
			ScoreVO value = hMap.get(hak);
			System.out.println(hak + ":" + value);
			return;
		
		} else {
		
			System.out.println(hak + ": 해당 학번 존재 안함");
		
		}
		
/*		//방법1 : key값인 hak을 통해 vo 객체 생성. 클래스는 초기값이 null. 해당하는 학번이 없을 경우 vo객체는 null값
 
		ScoreVO vo = hMap.get(hak);
		
		if(vo==null){	
			System.out.println("학번이 없습니다!");
			return;
		}
		System.out.println(hak + " " + vo.toString());
*/		



	}

	@Override
	public void findName() {

		System.out.print("검색하고 싶은 이름?");
		String fName = sc.next();

		Iterator<String> it2 = hMap.keySet().iterator();
		boolean flag = false; //찾는 이름이 있는지 flag 사용

		while (it2.hasNext()) { //동일 이름이 여러개일 수 있음. break 쓰면 안됨. 가지고 있는 데이터 다 돌려봐야 함.
		
			String key = it2.next();
			ScoreVO vo = hMap.get(key);
			
			if (vo.getName().equals(fName)) { 
			
				System.out.println("학번:" + key + "점수 :" + vo);
				flag = true; //한번이라도 동일한 이름이 있으면 flag를 true로 변경
			
			}
		
		}
		
		if (!flag) {
			System.out.println("해당하는 이름이 없어요");
		}

	}

}
