package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.StudyGroup;

public class GroupDAO {
private JDBCUtil jdbcUtil = null;
	
	public GroupDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	//스터디 그룹 생성
	public int create(StudyGroup studyGroup) throws SQLException {
		String sql = "INSERT INTO StudyGroup VALUES (" + "'g'||Sequence_commentId.nextval" + ", ?, ?, ?, ?)";		
		Object[] param = new Object[] {studyGroup.getGroupName(), studyGroup.getGroupCategory(), studyGroup.getGroupDescription(), studyGroup.getCode()};				
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
	
	//그룹 찾을때 이름으로 찾을거 같아서 변경
	public StudyGroup search(String groupName) throws SQLException {
        String sql = "SELECT * "
        			+ "FROM STUDYGROUP "
        			+ "WHERE groupName = ? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {groupName});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				StudyGroup group = new StudyGroup(		// User 객체를 생성하여 학생 정보를 저장
						rs.getString("groupId"),
						groupName,
						rs.getInt("groupCategory"),
						rs.getString("groupDescription"),
						rs.getString("code"));
				return group;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
//	
//	public boolean login(String userId, String password) {
//		String sql = "SELECT * FROM MEMBER WHERE userId = ?";
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
//		
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
//			if (rs.next()) {						// 학생 정보 발견
//				Member member = new Member(		// User 객체를 생성하여 학생 정보를 저장
//						userId,
//						rs.getString("userName"),
//						rs.getString("pwd"),
//						rs.getString("phone"),
//						rs.getString("birth"),
//						rs.getString("email"));
//				return true;
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource 반환
//		}
//		return false;
//	}
}
