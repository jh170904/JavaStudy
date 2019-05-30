package com.day21;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DBConn;

public class ScoreTest {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		Scanner sc = new Scanner(System.in);
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		int ch;
		
		try {
			sql = "select hak,name from score";
			
			//stmt = conn.createStatement();//순방향으로만 이동.(테이블을 레코드 순서대로 읽음)
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			//INSERT문은 자동커밋인데, UPDATE의 경우에는 COMMIT이 진행되야함 그래서 SENSITIVE,INSENSITIVE 설정
			//TYPE_SCROLL_SENSITIVE : 수정 결과 바로 반영 안됨
			//TYPE_SCROLL_INSENSITIVE : 수정 결과 바로 반영(순/역방향 검색 가능)
			//CONCUR_READ_ONLY : 읽기 전용
			//CONCUR_UPDATABLE : 수정 가능
			
			rs = stmt.executeQuery(sql);
			while(true){
				
				do{
					System.out.println("1.처음 2.이전 3.다음 4.마지막 5.종료: ");
					ch = sc.nextInt();
				}while(ch<1||ch>5);
				
				switch(ch){
				
				case 1: 
					if(rs.first()){
						System.out.println("처음: "+ rs.getString(1) + ":" + rs.getString(2));
					}
					break;
				
				case 2:
					if(rs.previous()){
						System.out.println("이전: "+ rs.getString(1) + ":" + rs.getString(2));
					}
					break;
					
				case 3:
					if(rs.next()){
						System.out.println("다음: "+ rs.getString(1) + ":" + rs.getString(2));
					}
					break;	
					
				case 4:
					if(rs.last()){
						System.out.println("마지막: "+ rs.getString(1) + ":" + rs.getString(2));
					}
					break;
					
				default:
					rs.close();
					stmt.close();
					DBConn.close();
					System.exit(0);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
