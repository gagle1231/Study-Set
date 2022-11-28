package controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Join;
import model.Member;
import model.StudyGroup;
import model.Task;
import model.service.TaskManager;

public class ViewTaskController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		//Member member = (Member) session.getAttribute("loginmember");
		//StudyGroup group = (StudyGroup) session.getAttribute("studyGroup");
		//TaskManager taskManager = TaskManager.getInstance();
		//List <Task> taskList = taskManager.getList(group.getGroupId());
		//request.setAttribute("taskList", taskList);
		return "/group/task/main.jsp";
	}

}

