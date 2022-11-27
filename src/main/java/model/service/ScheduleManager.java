package model.service;

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
	
	public List<Schedule> find(String groupId){
		List<Schedule> scheduleList = scheduleDao.getList(groupId);
		return scheduleList;
	}

}
