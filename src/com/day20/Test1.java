package com.day20;

import java.sql.Connection;

import com.db.DBConn;

public class Test1 {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();//디비를 찾아가서 연결해놓은 파이프라인을 conn에 할당
		
		if(conn==null){
			
			System.out.println("데이터베이스 연결 실패!!");
			System.exit(0);
		}
		System.out.println("데이터베이스 연결 성공!!");
		DBConn.close();
	}

}
