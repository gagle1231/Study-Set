package controller.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.StudyGroup;
import model.service.GroupManager;

public class SubmitController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		GroupManager manager = GroupManager.getInstance();
		StudyGroup studyGroup = manager.getGroup(request.getParameter("groupName"));
		session.setAttribute("studyGroup", studyGroup);
		return "redirect:/group/task/main";
	}
	
}
