package com.day21;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.db.DBConn;

//해당 데이터에 대한 정보를 갖고있는 데이터
//DB내의 데이터에 대한 소유자, 데이터 크기 정보

public class MetaTest {

	public static void main(String[] args) {
		
		Connection conn =DBConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		String sql;
		try {
			sql = "select * from score";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			
			//필드수
			int cols = rsmd.getColumnCount();
			
			//필드정보출력
			for(int i=1;i<=cols;i++){
				System.out.print("필드명: "+ rsmd.getColumnName(i));
				System.out.print(", 필드타입: " +rsmd.getColumnType(i));
				System.out.print(", 필드타입명: " +rsmd.getColumnTypeName(i));
				System.out.print(", 필드폭: " +rsmd.getPrecision(i));
				System.out.println();
			}			
			System.out.println();
			
			//데이터출력
			while(rs.next()){
				for(int i=1; i<=cols; i++){
					System.out.print(rs.getString(i)+ " ");
				}
				System.out.println();
			}
			
			rs.close();
			stmt.close();
			DBConn.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
