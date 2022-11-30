package controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.StudyGroup;
import model.Task;
import model.service.TaskManager;

public class ViewTaskController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		StudyGroup group = (StudyGroup) session.getAttribute("studyGroup");
		TaskManager manager = TaskManager.getInstance();
		List<Task> list = (List<Task>)manager.getList(group.getGroupId());
		request.setAttribute("group", group);
		request.setAttribute("list", list);
		return "/group/task/list.jsp";
	}

}
