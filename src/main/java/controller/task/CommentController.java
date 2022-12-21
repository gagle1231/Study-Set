package controller.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.Submit;
import model.Task;
import model.service.CommentManager;
import model.service.TaskManager;

public class CommentController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      HttpSession session = request.getSession();
      
      Task task = (Task) session.getAttribute("task");
      String userId = request.getParameter("userId");
      String userName = request.getParameter("userName");
      String submitCommentId = request.getParameter("commentId");
      
      // 댓글 삭제하기
      if (request.getMethod().equals("GET")) {
         request.setCharacterEncoding("utf-8");
         CommentManager manager = CommentManager.getInstance();
         manager.removeMemoComment(submitCommentId);
         return "redirect:/group/task/submit?userId=" + userId + 
        		 "&userName=" + userName + "&taskId=" + task.getTaskId();
      }

      return "/group/task/submit.jsp";
   }
}