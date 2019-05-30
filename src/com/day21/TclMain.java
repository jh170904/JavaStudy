package com.day21;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DBConn;

//트랜잭션 처리
//로직이 중요. 전체적인 흐름중에 오류가 발생한다면 rollback 진행이 어느단계까지 되야할지 명확해야함
public class TclMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql;
		
		int ch;
		int id;
		String name, birth, tel;
		
		try {
			while(true){
				
				do{
					System.out.print("1.입력 2.출력 3.종료 :");
					ch = sc.nextInt();
				}while(ch<1||ch>3);

				switch(ch){
					case 1:
					conn.setAutoCommit(false);//입력시 autocommit되므로 설정 변경
					//test1,test2,test3 테이블 모두 정상적으로 입력되야 commit되도록 설정하기 위함
					//중간에 입력시 오류가 난다면 rollback 진행
					
					System.out.print("아이디[숫자]? ");
					id = sc.nextInt();
					System.out.print("이름? ");
					name = sc.next();
					System.out.print("생일[yyyy-mm-dd]? ");
					birth = sc.next();
					System.out.print("전화");
					tel = sc.next();
					
					//세개의 sql중 하나라도 잘못들어가면 rollback 진행된다.
					//test1테이블 입력
					sql= String.format("insert into test1 (id, name) values(%d,'%s')",id, name);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					stmt.close();

					//test2테이블 입력
					sql= String.format("insert into test2 (id, birth) values(%d,'%s')",id, birth);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					stmt.close();
					
					//test3테이블 입력
					sql= String.format("insert into test3 (id, tel) values(%d,'%s')",id, tel);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					stmt.close();
					
					conn.commit();
					break;
					
					case 2:
						//출력
						
					case 3:
						DBConn.close();
						System.exit(0);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
