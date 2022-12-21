package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.Submit;
import model.Task;


public class TaskDAO {
	private JDBCUtil jdbcUtil = null;

	public TaskDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}


	//새로운 과제 생성
	public int create(Task task, String groupId) throws SQLException, ParseException {

		String sql = "INSERT INTO TASK VALUES('t'||LPAD(Sequence_taskId.nextval, 7, '0'), ?, ?, ?, ?, ? )";

		Object[] param = new Object[] {task.getName(), task.getStartDate(), task.getEndDate(), task.getDescription(), groupId};				
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

	//과제 리스트 가져오기
	public List<Task> getList(String groupId){
		String sql = "SELECT * FROM TASK WHERE groupId = ? ";                        
		jdbcUtil.setSqlAndParameters(sql, new Object[]{groupId});	

		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<Task> taskList = new ArrayList<Task>();	
			while (rs.next()) {
				Task task = new Task(
						rs.getString("taskId"),
						rs.getString("taskName"),
						rs.getString("startDate"),
						rs.getString("endDate"),
						rs.getString("taskDescription")
						);
				taskList.add(task);	
			}		
			return taskList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public Task getTask(String taskId){
		String sql = "SELECT * FROM TASK WHERE taskId = ?";                        
		jdbcUtil.setSqlAndParameters(sql, new Object[] { taskId });

		try {
			ResultSet rs = jdbcUtil.executeQuery();	

			if (rs.next()) {
				Task task = new Task(
						taskId, 
						rs.getString("taskName"), 
						rs.getString("startDate"), rs.getString("endDate"), 
						rs.getString("taskDescription"));
				return task;
			}		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return null;
	}
	
	//과제 제출하기
	public int submitTask(String taskId, Submit submit) throws SQLException{

		String sql = "INSERT INTO SUBMIT VALUES (?, ?, ?, sysdate , ?, 's'||LPAD(Sequence_submitId.nextval, 7, '0'))";  

		jdbcUtil.setSqlAndParameters(sql, new Object[] {submit.getUserId(), submit.getFilePath(), submit.getSubmitContents(), taskId});	
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

	public Submit getSubmit(String taskId, String userId) {
		String sql = "SELECT * FROM SUBMIT WHERE taskId = ? and userId = ? ";                        
		jdbcUtil.setSqlAndParameters(sql, new Object[] {taskId, userId});

		try {
			ResultSet rs = jdbcUtil.executeQuery();	

			if (rs.next()) {
				Submit submit = new Submit(
						rs.getString("userId"), rs.getString("filePath"), 
						rs.getString("submitContents"), rs.getString("submitDate"), 
						rs.getString("taskId"), rs.getString("submitId"));
				return submit;
			}		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return null;
	}
	//과제 리스트 가져오기
		public List<Submit> getSubmitList(String taskId){
			String sql = "SELECT * FROM Submit WHERE taskId = ? ";                        
			jdbcUtil.setSqlAndParameters(sql, new Object[]{taskId});	

			try {
				ResultSet rs = jdbcUtil.executeQuery();		
				List<Submit> submitList = new ArrayList<Submit>();	
				while (rs.next()) {
					Submit submit = new Submit(
							rs.getString("userId"),
							rs.getString("filePath"),
							rs.getString("submitContents"),
							rs.getString("submitDate"),
							taskId,
							rs.getString("submitId")
							);
					submitList.add(submit);	
				}		
				return submitList;					

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}
}
