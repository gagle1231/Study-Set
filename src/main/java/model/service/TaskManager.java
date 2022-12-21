package model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Join;
import model.StudyGroup;
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

	// task DAO수정하기
	public Task getTask(String taskId) throws SQLException {
		Task task = taskDao.getTask(taskId);
		return task;
	}

	public int submitTask(String taskId, Submit submit) throws SQLException, ParseException {
		return taskDao.submitTask(taskId, submit);

	}

//	public int update(Submit submit) throws SQLException, ParseException {
//		return taskDao.update(submit);
//	}
	public int update(String submitContents, String submitId) throws SQLException, ParseException {
		return taskDao.update(submitContents, submitId);
	}
//	public Submit getSubmit(String submitId)  throws SQLException {
//		Submit submit = taskDao.getSubmit(submitId);
//		return submit;
//	}
	public Submit getSubmit(String taskId, String userId) throws SQLException {

		Submit submit = taskDao.getSubmit(taskId, userId);
		if (submit == null) {
			return null;
		}
		return submit;
	}
//	public List<Submit> getSubmitList(String taskId) throws SQLException {
//		return taskDao.getSubmitList(taskId);
//	}
}
