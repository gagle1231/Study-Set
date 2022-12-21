package controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Member;
import model.Submit;
import model.Task;
import model.service.TaskManager;

public class UpdateSubmitController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateSubmitController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Member loginmember = (Member) session.getAttribute("loginmember");
		Task task = (Task) session.getAttribute("task");
		if (request.getMethod().equals("GET")) {
			TaskManager manager = TaskManager.getInstance();
			System.out.println("taskId, userId: "+task.getTaskId()+ ", "+loginmember.getUserId());
			Submit submit = manager.getSubmit(task.getTaskId(), loginmember.getUserId());
			request.setAttribute("submit", submit);

			return "/group/task/update.jsp";
		}

		// POST request (회원정보가 parameter로 전송됨)
		String submitId = request.getParameter("submitId");
		String updateContents = request.getParameter("submitContents");
		TaskManager manager = TaskManager.getInstance();
		manager.update(updateContents, submitId);
		return "redirect:/group/task/detail?&taskId=" + task.getTaskId();
	}
}