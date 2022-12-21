//package controller.task;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import controller.Controller;
//import model.service.CommentManager;
//import model.service.TaskManager;
//import model.Member;
//import model.Submit;
//import model.SubmitComment;
//import model.Task;
//
//public class CommentController implements Controller {
//
//	@Override
//	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("utf-8");
//		HttpSession session = request.getSession();
//		Member loginmember = (Member) session.getAttribute("loginmember");
//		Task task = (Task) session.getAttribute("task");
//		String userId = request.getParameter("userId");
//		String userName = request.getParameter("userName");
//		CommentManager manager = CommentManager.getInstance();
//		TaskManager tmanager = TaskManager.getInstance();
//		String taskId = request.getParameter("taskId");
//		Submit submit = tmanager.getSubmit(taskId, userId);
//		System.out.println("글작성자ID, 이름 " + userId + ", " + userName);
//		System.out.println("로그인ID, 이름: " + loginmember.getUserId() + ", " + loginmember.getUserName());
//		
//		if (request.getServletPath().equals("/comment/add")) {
//			if (request.getMethod().equals("POST")) {
//				request.setCharacterEncoding("utf-8");
//				String commentContents = request.getParameter("commentContents");
//				String annonymous = request.getParameter("annonymous");
//				String submitId = submit.getSubmitId();
//				String commentDate = request.getParameter("commentDate");
//				char anno = annonymous == null ? 'N' : 'Y';
//
//				SubmitComment comment = new SubmitComment(null, loginmember.getUserId(), commentContents, anno,
//						submitId, commentDate);
//				try {
//					manager.addSubmitComment(comment, submitId);
//					return "redirect:/group/task/submit?userId=" + userId + "&userName=" + userName + "&taskId="
//							+ task.getTaskId();
//				} catch (SQLException se) {
//					se.printStackTrace();
//					return "/group/task/submit";
//				} catch (Exception e) {
//					e.printStackTrace();
//					return "/group/task/submit";
//				}
//			}
//		}
//		return "redirect:/group/task/submit?userId=" + userId + "&userName=" + userName + "&taskId=" + task.getTaskId();
//	}
//}