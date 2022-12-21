package model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import model.TimeSlot;
import model.dao.TimeSlotDAO;
public class ChartManager {
	private static ChartManager chartManager = new ChartManager();
	private TimeSlotDAO timeDao;
	
	private ChartManager() {
		try {
			timeDao = new TimeSlotDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static  ChartManager getInstance() {
		return chartManager;
	}
	
	public List<TimeSlot> getChart(String groupId) throws  Exception, SQLException{
		List<TimeSlot> list= timeDao.getTimeSlot(groupId);
		if(list==null) 
			throw new Exception();
		else
			return list;
	}
	
	public List<TimeSlot> getUserChar(String groupId, String userId) throws Exception{
		List<TimeSlot> list= timeDao.getUserTimeSlot(groupId, userId);
		if(list==null) 
			throw new Exception();
		else
			return list;
	}
	
	public void deleteUserTimeSlot(String userId, String groupId) {
		timeDao.deleteTimeSlot(groupId, userId);
	}
	public void setTimeSlot(TimeSlot t, String userId, String groupId) {
		try {
			
			timeDao.addTimeSlot(t, userId, groupId);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
