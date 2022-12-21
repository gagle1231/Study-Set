package model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import model.Schedule;
import model.dao.ScheduleDAO;

public class ScheduleManager {
	private static ScheduleManager scheduleManager = new ScheduleManager();
	private ScheduleDAO scheduleDao;
	
	private ScheduleManager() {
		try {
			scheduleDao = new ScheduleDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static ScheduleManager getInstance() {
		return scheduleManager;
	}
	
	public Schedule getSchedule(String scheduleId) {
		Schedule schedule = scheduleDao.getSchedule(scheduleId);
		return schedule;
	}
	public List<Schedule> find(String groupId){
		List<Schedule> scheduleList = scheduleDao.getList(groupId);
		return scheduleList;
	}
	
	public void create(Schedule schedule) {
		try {
			scheduleDao.create(schedule);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
