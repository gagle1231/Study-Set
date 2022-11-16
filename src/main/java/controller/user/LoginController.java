package controller.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
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
//	
//			// 세션에 사용자 로그인 한 회원 정보 저장
			HttpSession session = request.getSession();
            session.setAttribute("loginmeber", member); 
            return "redirect:/user/main";			
		} catch (Exception e) {
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e.getMessage());
            return "/user/login.jsp";			
		}	
    }
}
