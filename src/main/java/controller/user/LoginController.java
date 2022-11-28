package controller.user;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Join;
import model.Member;
import model.StudyGroup;
import model.service.GroupManager;
import model.service.MemberManager;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		try {
//			// 모델에 로그인 처리를 위임
			MemberManager manager = MemberManager.getInstance();
			Member member = (Member) manager.login(userId, password);
//			GroupManager groupManager = GroupManager.getInstance();
//			List <Join> userJoinList = groupManager.getUserGroupList(userId);
//	
//			// 세션에 사용자 로그인 한 회원 정보 저장
			HttpSession session = request.getSession();
            session.setAttribute("loginmember", member); 
//            session.setAttribute("joinList", userJoinList);
            return "redirect:/user/group/list";			
		} catch (Exception e) {
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e.getMessage());
            return "/user/login.jsp";			
		}	
    }
}
