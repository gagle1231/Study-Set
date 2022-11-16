package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

public class MemberDAO {
private JDBCUtil jdbcUtil = null;
	
	public MemberDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(Member user) throws SQLException {
		String sql = "INSERT INTO USERINFO VALUES (?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}
	
	public Member findMember(String userId) throws SQLException {
        String sql = "SELECT * "
        			+ "FROM MEMBER "
        			+ "WHERE userId = ? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				Member member = new Member(		// User 객체를 생성하여 학생 정보를 저장
						userId,
						rs.getString("userName"),
						rs.getString("pwd"),
						rs.getString("phone"),
						rs.getString("birth"),
						rs.getString("email"));
				return member;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public boolean login(String userId, String password) {
		String sql = "SELECT * FROM MEMBER WHERE userId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				Member member = new Member(		// User 객체를 생성하여 학생 정보를 저장
						userId,
						rs.getString("userName"),
						rs.getString("pwd"),
						rs.getString("phone"),
						rs.getString("birth"),
						rs.getString("email"));
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
}
