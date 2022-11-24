package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.TimeSlot;

public class TimeSlotDAO {
	private JDBCUtil jdbcUtil = null;

	public TimeSlotDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}
		
	// 타임슬롯 작성
	public int addTimeSlot(TimeSlot timeSlot, String userId, String groupId) throws SQLException, ParseException {
		String sql = "INSERT INTO TIMESLOT VALUES('ts'||SEQUENCE_TIMESLOTID.NEXTVAL" + ", ?, ?, ?, ?, ? )";
		
		Object[] param = new Object[] { userId, timeSlot.getDay(), timeSlot.getStartTime(), timeSlot.getEndTime(), groupId };
		
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		
		return 0;
	}
	
	// 타임슬롯 가져오기 - 매개변수 groupId
	public List<TimeSlot> getTimeSlot(String groupId) {
		String sql = "SELECT * FROM TIMESLOT WHERE groupId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { groupId });
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<TimeSlot> timeSlotList = new ArrayList<TimeSlot>();
			while (rs.next()) {
				TimeSlot timeSlot = new TimeSlot(
						rs.getString("timeSlotId"), 
						rs.getString("userId"),
						rs.getInt("day"),
						rs.getInt("startTime"),
						rs.getInt("endTime"));
				timeSlotList.add(timeSlot);
			}
			return timeSlotList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}
	
	// 타임슬롯 리스트 가져오기 - 매개변수 groupId, userId
	public List<TimeSlot> getUserTimeSlot(String groupId, String userId) {
		String sql = "SELECT * FROM TIMESLOT WHERE groupId = ? AND userId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { groupId, userId });
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<TimeSlot> userTimeSlotList = new ArrayList<TimeSlot>();
			while (rs.next()) {
				TimeSlot timeSlot = new TimeSlot(
						rs.getString("timeSlotId"), 
						rs.getString("userId"),
						rs.getInt("day"),
						rs.getInt("startTime"),
						rs.getInt("endTime"));
				userTimeSlotList.add(timeSlot);
			}
			return userTimeSlotList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}
	
	// 타임슬롯 수정
	
	
	// 타임슬롯 삭제
	
}
