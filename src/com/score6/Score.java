package com.score6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DBConn;

public class Score {
	
	Scanner sc = new Scanner(System.in);
	//getter, setter 사용하는 게 일반적이지만 DB연동 예시이므로 현재는 생략하고 진행
	String hak,name;
	int kor,eng,mat;
	int tot,avg;
	
	//1.입력
	public int insertData(){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;//클래스의 초기값은 null 이므로 Statement도 null로 초기화
		//Statement는 sql문을 전달해주면 가져다가 실행하는 역할 진행
		String sql;
		
		try {
			
			System.out.print("학번? ");
			hak = sc.next();
			
			System.out.print("이름? ");
			name = sc.next();
			
			System.out.print("국어? ");
			kor = sc.nextInt();
		
			System.out.print("영어? ");
			eng = sc.nextInt();
			
			System.out.print("수학? ");
			mat = sc.nextInt();
			
			sql = "insert into score (hak,name,kor,eng,mat) values(";
			sql += "'" + hak + "'," ;
			sql += "'" + name + "'," ;
			sql += kor + ",";
			sql += eng + ",";			
			sql += mat + ")";			
			
			//System.out.println(sql);//확인용
			stmt = conn.createStatement();//statement는 connection이 생성함
			result = stmt.executeUpdate(sql);//executeUpdate는 insert, update, delete(DML문장일때) 사용
			stmt.close();

			System.out.println("데이터가 입력되었습니다.");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;		
	}
	
	//2.수정
	public int updateData(){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;//클래스의 초기값은 null 이므로 Statement도 null로 초기화
		String sql;
		
		try {
			
			System.out.print("수정할 학번? ");
			hak = sc.next();
			
			
			System.out.print("국어? ");
			kor = sc.nextInt();
		
			System.out.print("영어? ");
			eng = sc.nextInt();
			
			System.out.print("수학? ");
			mat = sc.nextInt();
			
			sql = "update score set kor="+kor+", eng="+eng+", mat="+mat + " where hak = '"+hak+"'";

			System.out.println(sql);//확인용
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);//executeUpdate는 insert, update, delete(DML문장일때) 사용
			stmt.close();

			System.out.println("데이터가 수정되었습니다.");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;		
	}
	
	//3.삭제
	public int deleteData(){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;//클래스의 초기값은 null 이므로 Statement도 null로 초기화
		String sql;
		
		try {
			System.out.print("삭제할 학번? ");
			hak = sc.next();
			
			sql = "delete score where hak = '"+hak+"'";
			
			System.out.println(sql);//확인용
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);//executeUpdate는 insert, update, delete(DML문장일때) 사용
			stmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	
	//4.전체출력
	public void selectAll(){
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null; //statement가 실행되고 난 후 테이블이 반환됨. 반환된 테이블을 담을 변수 
		String sql;
		String str;
		
		try {
						
			sql = "select hak,name,kor,eng,mat,";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg ";
			sql += "from score order by hak";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			//테이블을 담아야하는데 해당 테이블의 레코드의 수를 알 수 없음. 그렇기 때문에 반복문 사용해야함
			//커서가 BOF(BEGIN OF FILE) ~ EOF(END OF FILE) 회전을 해야함.
			
			//rs.next가 존재할때까지 반복
			while(rs.next()){
				hak = rs.getString(1); //첫번째 컬럼의 값, 컬럼명을 사용해도 됨
				name = rs.getString("name");	
				kor = rs.getInt("kor");
				eng = rs.getInt(4);
				mat = rs.getInt("mat");
				tot = rs.getInt(6);
				avg = rs.getInt("avg");
				
				str = String.format("%5s %8s %4d %4d %4d %4d %4d", 
						hak, name, kor, eng, mat, tot, avg);
				System.out.println(str);
			}
			
			rs.close();
			stmt.close();
			DBConn.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	//5.이름검색
	public void searchName(){
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		ResultSet rs = null; //statement가 실행되고 난 후 테이블이 반환됨. 반환된 테이블을 담을 변수 
		String sql;
		String str;
		
		try {
			
			System.out.print("검색할 이름? ");
			String searchName = sc.next();
			
			sql = "select hak,name,kor,eng,mat,";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg ";
			sql += "from score ";
			sql += "where name like '%" + searchName +"%' "; 
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				hak = rs.getString(1); //첫번째 컬럼의 값, 컬럼명을 사용해도 됨
				name = rs.getString("name");	
				kor = rs.getInt("kor");
				eng = rs.getInt(4);
				mat = rs.getInt("mat");
				tot = rs.getInt(6);
				avg = rs.getInt("avg");
				
				str = String.format("%5s %8s %4d %4d %4d %4d %4d", 
						hak, name, kor, eng, mat, tot, avg);
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
}
