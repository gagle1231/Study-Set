package controller.money;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.StudyGroup;
import model.Dues;
import model.service.MoneyManager;

public class DuesController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MoneyManager manager = MoneyManager.getInstance();
		StudyGroup studyGroup = manager.getGroup(request.getParameter("groupName"));
		List<Dues> duesList = manager.getDuesList(request.getParameter("groupId"));
		session.setAttribute("studyGroup", studyGroup);
		
		return "redirect:/group/money/dues";
	}

}