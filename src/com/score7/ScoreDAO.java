package com.score7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

//PreparedStatement

public class ScoreDAO {
//SQL 문 쓰는 클래스를 별도로 생성
//DAO : data access Object

	//1.insert
	public int insertData(ScoreDTO dto){
		//DTO를 전달받아 입력 진행. dto는 전달만 해주고 사라짐
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null; 
		String sql;
		
		try {
			//try문에서 문제발생시 sql문 자체의 문제거나, 실행시 문제
			
			sql = "insert into score (hak, name, kor, eng, mat) ";
			sql += "values (?,?,?,?,?)"; //인수의 개수만큼 물음표로 넣음. 정해진 기호
			
			pstmt = conn.prepareStatement(sql); 
			// prepareStatement: sql문을 미리 가져가서 유효한 쿼리인지 확인한 뒤 pstmt에 넣음. 
			// 다만 데이터는 없는 상태.
			
			pstmt.setString(1, dto.getHak()); 
			//Sets the designated parameter to the given Java String value
			//sql문의 첫번째 인덱스의 물음표 자리에 dto의 hak 입력
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());

			result = pstmt.executeUpdate();//PreparedStatement에서 이미 검사를 진행했으므로 매개변수 없이 실행
			pstmt.close();
		
		} catch (Exception e) {
			try { pstmt.close();} catch (Exception e2) {}
			try { DBConn.close();} catch (Exception e2) {}
		}
		
		return result;
	}
	
	//2.update
	public int updateData(ScoreDTO dto){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update score set kor=?, eng=?, mat=? ";
			sql += "where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setString(4, dto.getHak());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//3.delete
	public int deleteData(String hak){//삭제는 dto 전부 받을 필요없음. 학번 string하나만 입력받아도 문제없음.  
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = "delete score where hak=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hak);//매개변수 학번하나이므로 바로 할당해주면 됨
			result = pstmt.executeUpdate();
			pstmt.close();
	
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
		PreparedStatement pstmt = null;
		ResultSet rs=null; //select문의 경우 테이블을 반환하기 때문에 RESULTSET을 사용해야 한다.
		String sql;
		
		try {
			
			sql = "select hak, name, kor, eng, mat, ";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg, ";
			sql +="rank() over (order by (kor+eng+mat) desc) rank ";
			sql +="from score";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
				dto.setRank(rs.getInt("rank"));
				
				//dto를 리스트에 추가
				lists.add(dto);
			}
			rs.close();
			pstmt.close();
			
					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	//5.searchname
	public List<ScoreDTO> getList(String searchname){
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;
		
		try {
			
			sql = "select hak, name, kor, eng, mat, ";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg ";
			sql +="from score where name like ?";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,searchname + "%");		
			rs = pstmt.executeQuery();
			
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
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lists;
	}
	
	//6.searchhak
	public ScoreDTO searchHak(String hak){
		
		Connection conn = DBConn.getConnection();
		ScoreDTO dto = null;//검색한 데이터가 결과가 없을수도 있어서 객체를 null로 생성해도 됨
		PreparedStatement pstmt = null; 
		ResultSet rs=null;
		String sql;
		
		
		try {
			sql = "select hak, name, kor, eng, mat, ";
			sql += "(kor+eng+mat) tot, (kor+eng+mat)/3 avg ";
			sql +="from score where hak = ? ";
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, hak); 
			rs = pstmt.executeQuery();
			
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
			pstmt.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}
}
