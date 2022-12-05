package controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Submit;
import model.SubmitComment;
import model.service.CommentManager;
import model.service.TaskManager;

public class ViewSubmitController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		TaskManager manager = TaskManager.getInstance();
		CommentManager cmanager = CommentManager.getInstance();
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String taskId = request.getParameter("taskId");
		Submit submit = manager.getSubmit(taskId, userId);
		request.setAttribute("submit", submit);
		request.setAttribute("userName", userName);
		
//comment도 불러오기
		List<SubmitComment> list = cmanager.getSubmitCommentList(submit.getSubmitId());
		request.setAttribute("list", list);
		return "/group/task/view.jsp";
	}
}
