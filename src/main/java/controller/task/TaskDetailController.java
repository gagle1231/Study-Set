package controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.StudyGroup;
import model.Submit;
import model.Task;
import model.service.GroupManager;
import model.service.TaskManager;

public class TaskDetailController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		StudyGroup group = (StudyGroup) session.getAttribute("studyGroup");
		TaskManager manager = TaskManager.getInstance();
		GroupManager gmanager = GroupManager.getInstance();
		Task task = manager.getTask(request.getParameter("taskId"));
		List<Member> list = gmanager.getMember(group.getGroupId());
		//List<Submit> list = manager.getSubmitList(task.getTaskId());
		request.setAttribute("group", group);
		session.setAttribute("task", task);
		//session.setAttribute("list", list);
		session.setAttribute("list", list);
		return "/group/task/detail.jsp";
	}
	
}
