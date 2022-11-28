package controller.group;

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

			if(findMemberList!=null && findMemberList.size()>0)
				request.setAttribute("findMemberList", findMemberList); //request 객체에 저장			

			return "/group/main.jsp";   // 검색한 정보를 update form으로 전송     
		}	

		String groupName = request.getParameter("name");
		String code = request.getParameter("code");
		GroupManager manager = GroupManager.getInstance();
		StudyGroup newGroup = manager.check(groupName, code);
		try {
			if(newGroup!=null) {
				String userId = (String) session.getAttribute("loginmeber");
				Join join = new Join(userId, newGroup.getGroupId(), groupName);
				manager.addMember(join);
					
			}
		}catch(Exception e) {
			
		}
		return "redirect:/user/group/list";	
	}

}
