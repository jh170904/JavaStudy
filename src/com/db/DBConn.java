package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

//db를 연결하는 소스코드. db여러개 연결 가능

public class DBConn {
	
	private static Connection dbConn; //db연결자를 담을 수 있는 변수
	
	public static Connection getConnection(){
		//이미 메모리에 올라가있으므로 가져다 사용하면 됨
		
		if(dbConn==null){//null일 경우 연결이 되지 않은 상태
			
			try {
			
				String url = "jdbc:oracle:thin:@192.168.16.16:1521:TestDB"; 
				//jdbc방식으로 type4형식(thin:가장 직관적이고 가볍다), 해당 ip주소를 가진 1521포트의 TestDB로 연결하겠다.
				//@192.168.16.16 -> @localhost 클라이언트pc로 접속시.
				//EXPRESS로 설치하면 TestDB가 아니라 무조건 xe로 설정됨
				
				
				String user = "SUZI";
				String password = "A123";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");//다른클래스의 정보를 읽어올 때 사용
				//oracle.jdbc.driver위치의 OracleDriver클래스를 읽어온다.
				//오라클에 있는 드라이버가 있는지 확인하는 역할. 이 드라이버가 있어야 드라이버매니저를 실행할 수 있다
				//동적으로 클래스를 로딩한다. 좀 더 빠른 접근이 가능.
				
				dbConn = DriverManager.getConnection(url, user, password);
				//DriverManager를 통해서 내가 지정한 url, user, password로 스트림을 생성해서 dbConn에 담는 것
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return dbConn;
	}
/*
 	public static Connection getConnection1(){

		if(dbConn==null){
			
			try {
			
				String url = "jdbc:oracle:thin:@원하는아이피:1521:원하는디비"; 
				String user = "SUZI";
				String password = "A123";
				Class.forName("oracle.jdbc.driver.OracleDriver");

				dbConn = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return dbConn;
	}
 */
	
	public static void close(){
		
		if(dbConn!=null){//null이 아니면 연결되어 있는 상태

			try {
				
				if(!dbConn.isClosed()){
					dbConn.close();//반드시 close메소드를 호출해서 dbConn.close()가 사용되도록 처리해야한다.
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		dbConn = null;
		//파이프라인이 연결되어 있는 상태에서 연결을 끊게 되면 스트림안에 쓰레기값이 남게됨
		//두번째 연결시 쓰레기값으로 인하여 adapter 오류 발생
		//따라서 연결 종료시 항상 초기화를 진행해야한다.	
	}
}
