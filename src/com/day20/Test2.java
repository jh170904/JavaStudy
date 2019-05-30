package com.day20;

import java.sql.Connection;
import java.sql.Statement;

import com.db.DBConn;

public class Test2 {

	public static void main(String[] args) {
		
		//1. DBConn 클래스를 생성해놨으므로 연결해야 될때마다 가져다가 사용하면 됨.
		Connection conn = DBConn.getConnection();
		if(conn==null){
			System.out.println("연결 실패!!");
			System.exit(0);
		}
		
		//DB연결 방법
		//1.DriverManager가 Connection을 설정
		//2.Connection이 Statement를 생성(SQL구문을 실행하는 인터페이스)
		//3.Statement가 query를 실행(execute)
		
		try {
			
			//2.
			Statement stmt = conn.createStatement();
			String sql;
			
			//insert문
//			sql = "insert into score (hak,name,kor,eng,mat) ";
//			sql += "values ('222','이수지',50,20,80)";
			
			//update문
//			sql = "update score set name = '김태리', kor=10, eng=10, mat=10 ";
//			sql += "where hak = '222'";			

			//delete문
			sql = "delete score where hak='222'";
			
			//3.
			int result = stmt.executeUpdate(sql); //stmt가 sql매개변수를 가져가서 db에 실행을 요청한다. 
												  //executeUpdate: 잘 실행되면 1, 오류 발생시 0 을 반환한다
			
			if(result==1){
				System.out.println("삭제 성공!!");//이 방식으로 입력되는 데이터는 자동커밋
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		DBConn.close();
	}
}
