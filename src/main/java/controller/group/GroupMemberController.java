package controller.group;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Join;
import model.Member;
import model.StudyGroup;
import model.service.GroupManager;

public class GroupMemberController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		if (request.getMethod().equals("GET")) {	// GET request: 그룹원 검색
			GroupManager manager = GroupManager.getInstance();
			String memberName = request.getParameter("srchMem");
			StudyGroup group = (StudyGroup) session.getAttribute("studyGroup"); //지금 보고있는 그룹
			List<Member> findMemberList= manager.search(memberName, group.getGroupId());//회원 이름으로 그룹원 검색
			request.setAttribute("searching", true);
			if(findMemberList!=null && findMemberList.size()>0)
			{	
				request.setAttribute("findMemberList", findMemberList); //request 객체에 저장			
				
			}
			return "/group/main.jsp";   
		}	

		if (request.getMethod().equals("POST")) {
			request.setCharacterEncoding("utf-8");
			String groupName = request.getParameter("groupName");
			String code = request.getParameter("code");
			GroupManager manager = GroupManager.getInstance();
			StudyGroup newGroup = manager.check(groupName, code);
			try {
				if(newGroup!=null) {
					Member m = (Member) session.getAttribute("loginmember");
					Join join = new Join(m.getUserId(), newGroup.getGroupId(), groupName);
					manager.addMember(join);
					return "redirect:/user/group/list?joinGroupSuccess=true&joinGroup="+groupName;
				}else
					return "redirect:/user/group/list?joinGroupSuccess=false";
				
			} catch(Exception e) {
				e.printStackTrace();
				return "/user/main.jsp";
			}
		}
		return "redirect:/group/main";
	}
}
