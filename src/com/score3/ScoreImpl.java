package com.score3;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import javax.print.attribute.standard.Compression;

public class ScoreImpl implements Score {

	private Vector<ScoreVO> lists = new Vector<ScoreVO>();// 벡터안의 데이터 타입은
															// ScoreVO 클래스
	Scanner sc = new Scanner(System.in);

	@Override
	public int input() {

		int result = 0; // 나중에 DB사용시 데이터가 잘 입력되면 반환값 1로 설정. 지금은 그냥 void로 해도 상관없음


		System.out.println("데이터 입력....");

		ScoreVO vo = new ScoreVO();
		
		System.out.print("학번?");
		vo.setHak(sc.next()); // 스캐너로 읽음과 동시에 Setter 매개변수로
		System.out.print("이름?");
		vo.setName(sc.next());
		System.out.print("국어?");
		vo.setKor(sc.nextInt());
		System.out.print("영어?");
		vo.setEng(sc.nextInt());
		System.out.print("수학?");
		vo.setMat(sc.nextInt());

		lists.add(vo);

		return result;
	}

	@Override
	public void print() {

		// Iterator
		Iterator<ScoreVO> it = lists.iterator();

		while (it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}

	}

	@Override
	public void searchHak() {// 학번검색
		System.out.print("검색할 학번:");
		String searchHak = sc.next();// 111

		Iterator<ScoreVO> it = lists.iterator();

		while (it.hasNext()) { 
			
			ScoreVO vo = it.next();
			
			if (vo.getHak().equals(searchHak)) { //searchHak.equals(vo.getHak) 학번이 동일할 경우만 출력
			
				System.out.println(vo.toString());
				break;
			
			}
		
		}

	}

	@Override
	public void searchName() {// 이름검색
		System.out.print("검색할 이름:");
		String searchName = sc.next();

		Iterator<ScoreVO> it = lists.iterator();

		while (it.hasNext()) { 
			
			ScoreVO vo = it.next();
			
			if (vo.getName().equals(searchName)) { //searchHak.equals(vo.getHak) 학번이 동일할 경우만 출력
			
				System.out.println(vo.toString());
				//break; 동명이인이 발생할 수 있으므로 끝까지 검색해야 함
			
			}
		
		}

	}

	@Override
	public void descSortTot() {// 총점내림차순 정렬
		
		//Comparator interface
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {//Anonymous Inter type. 내부클래스

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getTot()<vo2.getTot()?1:-1; //부등호에 따라 <내림차순, >오름차순
			} 		
		
		};//익명의클래스이므로 ; 빠지면 안됨
		
		Collections.sort(lists,comp); 
		//출력
		Iterator<ScoreVO> it = lists.iterator();
		while (it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}
		
	}

	@Override
	public void ascSortHak() {// 학번오름차순 정렬

		Comparator<ScoreVO> comp1 = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getHak().compareTo(vo2.getHak()); //String method compareto()
			} 		
		
		};//익명의클래스이므로 ; 빠지면 안됨
			
		Collections.sort(lists,comp1); 
		//출력
		Iterator<ScoreVO> it = lists.iterator();
		while (it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}
		
	}

}
