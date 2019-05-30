package com.naver3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.db.DBConn;

public class NaverDAO {
	
	//1.INSERT 회원가입
	public int insertData(NaverDTO dto){
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null; 
		String sql;
		
		try {
			sql = "insert into naver (id, pw, name, gender, birth, email, tel) ";
			sql += "values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getTel());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	//2.UPDATE 회원정보수정
	public int updateData(NaverDTO dto){
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null; 
		String sql;
		
		try {
			sql = "update naver set name=?, gender=?, birth=?, email=?, tel=?) ";
			sql += "where id=? and pw=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getGender());
			pstmt.setString(3, dto.getBirth());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getTel());
			
			pstmt.setString(6, dto.getId());
			pstmt.setString(7, dto.getPw());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}	
		return result;
	}

	//3.DELETE 회원탈퇴
	public int deleteData(String id, String pw){
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		try {
			sql = "delete naver where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//4.SELECTALL 회원전체출력
	public List<NaverDTO> getList(){
		List<NaverDTO> lists = new ArrayList<NaverDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;
		try {
			sql = "select id, pw, name, gender, birth, email, tel ";
			sql +="from naver";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				NaverDTO dto = new NaverDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				
				lists.add(dto);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}
	
	
	//5.SEARCHID 아이디검색
	public NaverDTO searchID(String id, String pw){
		
		Connection conn = DBConn.getConnection();
		NaverDTO dto = null;//검색한 데이터가 결과가 없을수도 있어서 객체를 null로 생성해도 됨
		PreparedStatement pstmt = null; 
		ResultSet rs=null;
		String sql;
		
		try {
			sql = "select id, pw, name, gender, birth, email, tel ";
			sql +="from naver where id=? and pw=?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id); 
			pstmt.setString(2, pw); 
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto = new NaverDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));

			}
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}
}
