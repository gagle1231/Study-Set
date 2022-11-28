package controller.group;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Join;
import model.Member;
import model.StudyGroup;
import model.service.GroupManager;

public class GroupController implements Controller{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      //그룹 메인 컨트롤러
      if (request.getMethod().equals("POST")) {
    	  request.setCharacterEncoding("utf-8");
         StudyGroup group = new StudyGroup(
        		 null,
               request.getParameter("groupName"),
               1,
               request.getParameter("groupDescription"),
               request.getParameter("code")
               );
         try {
        	 HttpSession session = request.getSession();
        	 Member m = (Member) session.getAttribute("loginmember");
            GroupManager gManager = GroupManager.getInstance();
            gManager.create(group, m.getUserId());
            
           
            return "redirect:/user/group/list";
         }catch(SQLException se) {
        	 se.printStackTrace();
             return "/user/login";
         }
         
         catch (Exception e) {
            e.printStackTrace();
            return "/user/login";
         }
      }
      
      HttpSession session = request.getSession();
      GroupManager manager = GroupManager.getInstance();
      StudyGroup studyGroup = manager.getGroup(request.getParameter("groupName"));
      session.setAttribute("studyGroup", studyGroup);
      //List<Member> groupMembers = manager.g
      return "redirect:/group/main";
   }
}