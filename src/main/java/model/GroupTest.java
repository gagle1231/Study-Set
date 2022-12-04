package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import model.dao.CommentDAO;
import model.dao.GroupDAO;
import model.dao.MemberDAO;
import model.dao.TaskDAO;

public class GroupTest {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		GroupDAO dao = new GroupDAO();
		MemberDAO mdao = new MemberDAO();
		CommentDAO cdao = new CommentDAO();
		TaskDAO tdao = new TaskDAO();
		
		Task task = tdao.getTask("t0000004");
		Submit submit = tdao.getSubmit(task.getTaskId(), "zzimnii");
		System.out.println(submit.getSubmitContents());
		//cdao.addMemoComment(new MemoComment(null, "zzimnii", null, "굳굳", 'N', "20221120"), "m2");
		cdao.addSubmitComment(new SubmitComment(null, "gagle1231", "다음주에 시험이래", 'N', null, "20221220"), "s0000003");
//		ArrayList<MemoComment> mc = (ArrayList) cdao.getMemoCommentList("m2");
		ArrayList<SubmitComment> sc = (ArrayList) cdao.getSubmitCommentList("s0000003");

		//System.out.println(mc.get(0).getCommentContents());
		System.out.println(sc.get(0).getCommentContents());
		
		//dao.create(new StudyGroup(null, "모바일응용", 2, "모응 스터디", "09876"));
		StudyGroup group = dao.search("월요병");

//		if (group != null) {
//			System.out.println("gId: " + group.getGroupId());
//			System.out.println("gName: " + group.getGroupName());
//			System.out.println("gCategory: " + group.getGroupCategory());
//			System.out.println("gDescription: " + group.getGroupDescription());
//			System.out.println("gCode: " + group.getCode());
//			System.out.println();
//		} else {
//			System.out.println("부서를 찾지 못했음");
//		}
		
		// code가입 test
		/*if (dao.check("월요병", "1234"))
			System.out.println("가입성공");
		else
			System.out.println("코드 불일치");
		 */
		
		Member user = mdao.findMember("zzimnii");
		
		//그룹 가입
		//dao.addMember(new Join(user.getUserId(), group.getGroupId(), group.getGroupName()));
		//ArrayList<Join> g = (ArrayList) dao.getMyGroup("zzimnii");
		//System.out.println(g.get(0).getGroupName() + g.get(1).getGroupName());
		
		//ArrayList<StudyGroup> sg = (ArrayList) dao.getGroupList();
		//System.out.println(sg.get(2).getGroupName());
	}
}
