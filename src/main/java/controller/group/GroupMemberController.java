package controller.group;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.StudyGroup;
import model.service.GroupManager;

public class GroupMemberController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {	// GET request: 그룹원 검색
    		GroupManager manager = GroupManager.getInstance();
    		String memberName = request.getParameter("srchMem");
    		HttpSession session = request.getSession();
    		StudyGroup group = (StudyGroup) session.getAttribute("studyGroup"); //지금 보고있는 그룹
			List<Member> findMemberList= manager.search(memberName, group.getGroupId());//회원 이름으로 그룹원 검색
		
			if(findMemberList!=null && findMemberList.size()>0)
				request.setAttribute("findMemberList", findMemberList); //request 객체에 저장			
	
			return "/group/main.jsp";   // 검색한 정보를 update form으로 전송     
	    }	
    	
		return null;
    	// POST request 그룹 가입
    	
	}

}
