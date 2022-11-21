package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

public class MemberDAO {
private JDBCUtil jdbcUtil = null;
	
	public MemberDAO() {			
		jdbcUtil = new JDBCUtil();	
	}
		

	public int create(Member member) throws SQLException {
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {member.getUserId(), member.getUserName(), member.getPwd(), member.getPhone(), member.getBirth(), member.getEmail()};				
		jdbcUtil.setSqlAndParameters(sql, param);	
						
		try {				
			int result = jdbcUtil.executeUpdate();	
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	
		}		
		return 0;			
	}
	
	
	public Member findMember(String userId) throws SQLException {
        String sql = "SELECT * "
        			+ "FROM MEMBER "
        			+ "WHERE userId = ? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {					
				Member member = new Member(		
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
	
	public boolean existingUser(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM MEMBER WHERE userId=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
}
