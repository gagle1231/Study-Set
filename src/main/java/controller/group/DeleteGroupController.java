package controller.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.StudyGroup;
import model.service.ExistingGroupException;
import model.service.GroupManager;
import controller.Controller;

public class DeleteGroupController implements Controller{
	   @Override
	   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	      //GET: 그룹 선택 후 그룹 메인으로 리다이렉트
	      HttpSession session = request.getSession();
	      Member m = (Member) session.getAttribute("loginmember");
	      StudyGroup g = (StudyGroup) session.getAttribute("studyGroup");
	      GroupManager manager = GroupManager.getInstance();
	      int rslt = manager.leave(m.getUserId(), g.getGroupId());
	      
	      return "redirect:/user/group/list";
	   }
}
