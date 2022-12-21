package controller.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.Submit;
import model.Task;
import model.service.TaskManager;

public class SubmitController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      HttpSession session = request.getSession();
      Member member = (Member) session.getAttribute("loginmember");
      Task task = (Task) session.getAttribute("task");
      String userId = request.getParameter("userId");
      Submit submit = null;
      // Submit 제출하기
      if (request.getMethod().equals("POST")) {
         request.setCharacterEncoding("utf-8");
         submit = new Submit(member.getUserId(), request.getParameter("filePath"),
               request.getParameter("submitContents"), request.getParameter("submitDate"),
               request.getParameter("taskId"), request.getParameter("submitId"));

         TaskManager manager = TaskManager.getInstance();
         manager.submitTask(task.getTaskId(), submit);
         return "redirect:/group/task/detail?taskId=" + task.getTaskId();
      }
      TaskManager manager = TaskManager.getInstance();

      submit = manager.getSubmit(request.getParameter("submitId"), userId);
      session.setAttribute("submit", submit);
      return "/group/task/submit.jsp";
   }
}