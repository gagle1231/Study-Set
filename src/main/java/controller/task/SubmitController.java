package controller.task;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.StudyGroup;
import model.Task;
import model.Dues;
import model.Member;
import model.Submit;
import model.service.GroupManager;
import model.service.MoneyManager;
import model.service.TaskManager;

public class SubmitController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("POST")) {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
			String taskId = request.getParameter("taskId");
			String userId = request.getParameter("userId");
			Submit submit = new Submit(
					userId,
	    			request.getParameter("filePath"),
	    			request.getParameter("submitContents"),
	    			request.getParameter("submitDate"),
	    			taskId,
	    			null);
	         try {
	        	 session = request.getSession();
	        	 TaskManager manager = TaskManager.getInstance();
	        	 manager.submitTask(taskId, submit);
	        	 request.setAttribute("submit", submit);
	        	 return "redirect:/group/task/view";
	         }catch(SQLException se) {
	        	 se.printStackTrace();
	             return "/group/task/view";
	         }
	         catch (Exception e) {
	            e.printStackTrace();
	            return "/group/task/view";
	         }
		}
		HttpSession session = request.getSession();
	    TaskManager manager = TaskManager.getInstance();
	    Submit submit = (Submit) session.getAttribute("submit");
	    request.setAttribute("submit", submit);
	    return "/group/task/view.jsp";

	}
}
