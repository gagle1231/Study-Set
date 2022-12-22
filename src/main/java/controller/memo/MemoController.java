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
		GroupManager gmanager = GroupManager.getInstance();
		MemoManager manager = MemoManager.getInstance();
		
		String[] colorArr = { "#ff8080", "orange", "skyblue", "#F974DA", "#EDCBF5" };
		request.setAttribute("colorArr", colorArr);
		
		List<Member> memberList = gmanager.getMember(studyGroup.getGroupId());
		request.setAttribute("groupMemberList", memberList);
		
		List<Memo> memoList = manager.getList(studyGroup.getGroupId());
		System.out.println(memoList);
		
		request.setAttribute("memoList", memoList);
		
		return "/group/memo/memo.jsp";
	}

}