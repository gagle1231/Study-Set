package controller.group;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Join;
import model.Member;
import model.StudyGroup;
import model.service.GroupManager;

public class SearchMemberController implements Controller{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// HttpSession session = request.getSession(); 
		
		if (request.getMethod().equals("POST")) {	// GET request: 그룹원 검색
			GroupManager manager = GroupManager.getInstance();
			String memberName = request.getParameter("userName");
			String groupId = request.getParameter("groupName");
			List<Member> findMemberList= manager.search(memberName, groupId);//회원 이름으로 그룹원 검색
			request.setAttribute("searching", true);
			if(findMemberList!=null && findMemberList.size()>0)
			{	
				request.setAttribute("findMemberList", findMemberList); //request 객체에 저장			
				
			}  
			
			// 모달창에서 멤버 검색 후 부모창에서 새로고침될 때 다시 그룹 읽어옴
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginmember");
			GroupManager groupManager = GroupManager.getInstance();
			String groupName = request.getParameter("studyName");
			List<Member> srchMemberList= new ArrayList<>();
			List <Join> userJoinList;
			
			if(groupName == null || groupName.equals(""))  
				userJoinList = groupManager.getUserGroupList(member.getUserId());			
			else //그룹 검색
				userJoinList =  groupManager.getGroupList(groupName, member.getUserId());
					
			request.setAttribute("joinList", userJoinList);
			return "/user/main.jsp"; 
		}	

		return "redirect:/user/main";
	}
}