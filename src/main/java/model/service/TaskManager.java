package model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import model.Submit;
import model.Task;
import model.dao.*;

public class TaskManager {
	private static TaskManager taskManager = new TaskManager();
	private TaskDAO taskDao;

	private TaskManager() {
		try {
			taskDao = new TaskDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static TaskManager getInstance() {
		return taskManager;
	}

	public int create(Task task, String groupId) throws SQLException, ParseException {
		return taskDao.create(task, groupId);
	}

	public List<Task> getList(String groupId) throws SQLException {
		List<Task> taskList = taskDao.getList(groupId);
		return taskList;
	}
//	public getTask() {
//		
//	}
//	public getSubmitList() {
//		
//	}	
	public int submit(String taskId, Submit submit) throws SQLException{
		return taskDao.submitTask(taskId, submit);		
	}
//	public Submit getSubmit(String submitId) {
//	}
}
