package controller.group;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Join;
import model.Member;
import model.service.GroupManager;
public class ViewGroupController implements Controller{
	//회원의 그룹 리스트를 가져오는 컨트롤러
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//회원의 그룹 리스트 가져오기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginmember");
		GroupManager groupManager = GroupManager.getInstance();
		List <Join> userJoinList = groupManager.getUserGroupList(member.getUserId());
		request.setAttribute("joinList", userJoinList);
		return "/user/main.jsp";
	}

}
