package com.score8;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import oracle.jdbc.internal.OracleTypes;

import com.db.DBConn;

//CallableStatement

public class ScoreDAO {
//SQL 문 쓰는 클래스를 별도로 생성
//DAO : data access Object

	//1.insert
	public int insertData(ScoreDTO dto){
		//DTO를 전달받아 입력 진행. dto는 전달만 해주고 사라짐
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null; 
		String sql;
		
		try {
			
			//try문에서 문제발생시 sql문 자체의 문제거나, 실행시 문제
			
			sql = "{call insertScore(?,?,?,?,?)}"; //프로시저를 호출하는 것 
			cstmt = conn.prepareCall(sql); 
			// prepareStatement: sql문을 미리 가져가서 유효한 쿼리인지 확인한 뒤 pstmt에 넣음. 
			// 다만 데이터는 없는 상태.
			
			cstmt.setString(1, dto.getHak()); 
			//Sets the designated parameter to the given Java String value
			//sql문의 첫번째 인덱스의 물음표 자리에 dto의 hak 입력
			cstmt.setString(2, dto.getName());
			cstmt.setInt(3, dto.getKor());
			cstmt.setInt(4, dto.getEng());
			cstmt.setInt(5, dto.getMat());

			result = cstmt.executeUpdate();//PreparedStatement에서 이미 검사를 진행했으므로 매개변수 없이 실행
			cstmt.close();
		
		} catch (Exception e) {
			try { cstmt.close();} catch (Exception e2) {}
			try { DBConn.close();} catch (Exception e2) {}
		}
		
		return result;
	}
	
	//2.update
	public int updateData(ScoreDTO dto){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;
		
		try {
			
			sql = "{call updateScore(?,?,?,?)}";
			
			cstmt = conn.prepareCall(sql);
			
			//프로시저의 변수순서(?,?,?,?)와 set 순서는 동일해야 한다.
			cstmt.setString(1, dto.getHak());
			cstmt.setInt(2, dto.getKor());
			cstmt.setInt(3, dto.getEng());
			cstmt.setInt(4, dto.getMat());
			
			result = cstmt.executeUpdate();
			
			cstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//3.delete
	public int deleteData(String hak){//삭제는 dto 전부 받을 필요없음. 학번 string하나만 입력받아도 문제없음.  
		int result = 0;
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;
		
		try {
			sql =  "{call deleteScore(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, hak);//매개변수 학번하나이므로 바로 할당해주면 됨
			result = cstmt.executeUpdate();
			cstmt.close();
	
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//4.selectAll : dto가 담길 리스트가 필요하다.
	//쿼리에 해당하는 레코드가 dto에 담기고 이 dto들을 리스트에 담아서 반환값을 리스트로 설정 
	public List<ScoreDTO> getList(){
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		String sql;
		
		try {
			
			sql = "{call selectAllScore(?)}";//전체데이터를 select한 결과 presult가 들어가므로 ?가 1개. presult는 오라클에서 커서에 해당.
			cstmt = conn.prepareCall(sql);
			
			//out파라미터의 자료형 설정(커서를 받아낼 데이터 타입을 생성)
			//cstmt.registerOutParameter(1,OracleTypes.CURSOR);
			//오라클과 호환성문제 때문에 demo > build path > configure build path > library에 ojdbc6.jar 파일 재추가 진행
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out파라미터의 값을 돌려받는다
			rs = (ResultSet)cstmt.getObject(1); //cstmt실행결과를 object로 받아 downcast
			
			while(rs.next()){
				
				//레코드에 있는 내용을 dto에 입력
				ScoreDTO dto = new ScoreDTO();
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
				dto.setRank(rs.getInt("rank"));
				
				//dto를 리스트에 추가
				lists.add(dto);
			}
			rs.close();
			cstmt.close();
			
					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	//5.searchName
	public List<ScoreDTO> getList(String searchname){
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		String sql;
		
		try {
			
			sql = "{call selectNameScore(?,?)}";//물음표 변수의 순서는 out, in. 이 순서를 바꾸려면 프로시저의 변수 순서를 바꿔주면 된다.
			
			cstmt = conn.prepareCall(sql);
			
			//out 파라미터 자료형 설정
			//cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in 파라미터 
			cstmt.setString(2,searchname + "%");//'홍길' 검색시 '홍길%' 모든 사람 나오게끔 % 붙임
			
			//프로시져 실행
			cstmt.executeQuery();
			
			//out파라미터의 값 돌려 받기
			rs = (ResultSet)cstmt.getObject(1);
			
			//테이블에 레코드가 있을때까지 반복
			while(rs.next()){
				
				//레코드에 있는 내용을 dto에 입력
				ScoreDTO dto = new ScoreDTO();
				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
				
				//dto를 리스트에 추가
				lists.add(dto);
			}
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}
	
	//6.searchhak
	public ScoreDTO searchHak(String hak){
		
		Connection conn = DBConn.getConnection();
		ScoreDTO dto = null;//검색한 데이터가 결과가 없을수도 있어서 객체를 null로 생성해도 됨
		CallableStatement cstmt = null; 
		ResultSet rs=null;
		String sql;
		
		
		try {
			sql = "{call selectHakScore(?,?)}";//물음표 변수의 순서는 out, in 
			cstmt = conn.prepareCall(sql);
			
			//out 파라미터 자료형 설정
			//cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in 파라미터 
			cstmt.setString(2,hak);
			
			//프로시져 실행
			cstmt.executeQuery();
			
			//out파라미터의 값 돌려 받기
			rs = (ResultSet)cstmt.getObject(1);
			
			//데이터가 있거나 없거나 둘중 하나
			if(rs.next()){
				
				dto = new ScoreDTO();
				//레코드에 있는 내용을 dto에 입력				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
			}
			
			rs.close();
			cstmt.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}
}
