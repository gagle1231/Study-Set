package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Place;
import model.Schedule;

public class ScheduleDAO {

	private JDBCUtil jdbcUtil = null;
	
	public ScheduleDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	public List<Schedule> getList(String gid){
		String sql = "SELECT * FROM SCHEDULE WHERE groupId = ? ";                        
		jdbcUtil.setSqlAndParameters(sql, new Object[]{gid});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<Schedule> scheduleList = new ArrayList<Schedule>();	// member들의 리스트 생성
			while (rs.next()) {
				Schedule schedule = new Schedule(		
						rs.getString("scheduleId"), 
						gid,
						rs.getString("title"),
						rs.getString("scheduleDate"),
						rs.getString("startTime"),
						rs.getString("endTime"),					
						rs.getString("scheduleLocation"),
						rs.getString("scheduleDescription"),
						rs.getString("important").charAt(0));
				scheduleList.add(schedule);			// List에 Community 객체 저장
			}		
			return scheduleList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	//새로운 스캐줄 생성
	public int create(Schedule schedule) throws SQLException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMDD");
		
		// String sql = "insert into schedule values('1', 'tmp', '20011231', null, null, null,null, 'Y','s'||Sequence_scheduleId.nextval)";
		String sql = "insert into schedule values(?, ?, ?, ?, ?, ?, ?, ?,"
				+ "'s'||Sequence_scheduleId.nextval)";

		
		Object[] param = new Object[] { 
				schedule.getGroupId(), schedule.getTitle(),  schedule.getDate(), schedule.getStartTime(), schedule.getEndTime(), schedule.getLocation(),
				schedule.getDescription(), schedule.getImportant()};				
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
	
	//스캐줄 아이디로 스캐줄 반환
	public Schedule getInformation(String id) {
		String sql = "SELECT * "
    			+ "FROM SCHEDULE "
    			+ "WHERE scheduleId=? ";              
	jdbcUtil.setSqlAndParameters(sql, new Object[] {id});	

	try {
		ResultSet rs = jdbcUtil.executeQuery();		
		if (rs.next()) {						
			Schedule schedule = new Schedule(		
				id,
				rs.getString("groupId"),
				rs.getString("title"),
				rs.getString("scheduleDate"),
				rs.getString("startTime"),
				rs.getString("endTime"),					
				rs.getString("scheduleLocation"),
				rs.getString("scheduleDescription"),
				rs.getString("important").charAt(0));
			return schedule;
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		jdbcUtil.close();		// resource 반환
	}
	return null;
	}
	
	public List<Place> getPlaceList(){
		String sql = "SELECT * FROM Place ";                        
	jdbcUtil.setSql(sql);	// JDBCUtil에 query문과 매개 변수 설정
	
	try {
		ResultSet rs = jdbcUtil.executeQuery();		// query 실행
		List<Place> placeList = new ArrayList<Place>();	// member들의 리스트 생성
		while (rs.next()) {
			Place place = new Place(			// User 객체를 생성하여 현재 행의 정보를 저장
				rs.getString("placeId"),
				rs.getString("placeName"),
				rs.getString("address"),
				rs.getString("url"));
			placeList.add(place);			// List에 Community 객체 저장
		}		
		return placeList;					
			
	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		jdbcUtil.close();		// resource 반환
	}
	return null;
	}
	
	
}
