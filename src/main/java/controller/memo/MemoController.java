package controller.memo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.StudyGroup;
import model.Memo;
import model.Member;
import model.service.MemoManager;
import model.service.GroupManager;

public class MemoController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		StudyGroup studyGroup = (StudyGroup) session.getAttribute("studyGroup");
		Member member = (Member) session.getAttribute("loginmember");
		GroupManager gmanager = GroupManager.getInstance();
		MemoManager manager = MemoManager.getInstance();
		Memo memo = null;

		String[] colorArr = { "#ff8080", "orange", "skyblue", "#F974DA", "#EDCBF5" };
		request.setAttribute("colorArr", colorArr);

		List<Member> memberList = gmanager.getMember(studyGroup.getGroupId());
		request.setAttribute("groupMemberList", memberList);

		List<Memo> memoList = manager.getList(studyGroup.getGroupId());

		request.setAttribute("memoList", memoList);
		request.setAttribute("loginmember", member);

		if (request.getMethod().equals("POST")) {
			request.setCharacterEncoding("utf-8");
			memo = new Memo(member.getUserId(), studyGroup.getGroupId(), request.getParameter("memoContents"));
			manager.addMemo(memo, member.getUserId(), studyGroup.getGroupId());
			return "redirect:/group/memo";
		}

		return "/group/memo/memo.jsp";
	}

}