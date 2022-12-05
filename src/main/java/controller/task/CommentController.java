package controller.task;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.CommentManager;
import model.Member;
import model.Submit;
import model.SubmitComment;
import model.Task;

public class CommentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Member loginmember = (Member) session.getAttribute("loginmember");
		String userId = request.getParameter("userId");
		Submit submit = (Submit) request.getAttribute("submit");
		CommentManager manager = CommentManager.getInstance();
		if (request.getMethod().equals("POST")) {
			String commentContents = request.getParameter("commentContents");
			String annonymous = request.getParameter("annonymous");
			String submitId = request.getParameter("submitId");
			String commentDate = request.getParameter("commentDate");

			char anno = annonymous == null ? 'N' : 'Y';

			SubmitComment comment = new SubmitComment(null, userId, commentContents, anno, submitId, commentDate);
			try {
				manager.addSubmitComment(comment, submitId);
				return "redirect:/group/task/submit";
			} catch (SQLException se) {
				se.printStackTrace();
				return "/group/task/submit";
			} catch (Exception e) {
				e.printStackTrace();
				return "/group/task/submit";
			}
		}
		
		return "/group/task/submit";
	}
}
