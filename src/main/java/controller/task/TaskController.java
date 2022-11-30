package controller.task;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.StudyGroup;
import model.Task;
import model.service.GroupManager;
import model.service.TaskManager;

public class TaskController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("POST")) {
			HttpSession session = request.getSession();
			StudyGroup group = (StudyGroup) session.getAttribute("studyGroup");
			request.setCharacterEncoding("utf-8");
			Task task = new Task(
					request.getParameter("taskId"),
					request.getParameter("name"), 
					request.getParameter("startDate"),
					request.getParameter("endDate"), 
					request.getParameter("description")
					);
			try {
				session = request.getSession();
				TaskManager manager = TaskManager.getInstance();
				manager.create(task, group.getGroupId());
				session.setAttribute("task", task);
				return "redirect:/group/task/main";
			} catch (SQLException se) {
				se.printStackTrace();
				return "/group/task/main";
			} catch (Exception e) {
				e.printStackTrace();
				return "/group/task/main";
			}
		}
		
		HttpSession session = request.getSession();
		GroupManager manager = GroupManager.getInstance();
		StudyGroup studyGroup = manager.getGroup(request.getParameter("groupName"));
		session.setAttribute("studyGroup", studyGroup);
		return "redirect:/group/task/main";
	}
	
}
