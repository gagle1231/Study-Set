package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import model.dao.CommentDAO;

public class CommentTest {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		CommentDAO dao = new CommentDAO();

//		dao.addMemoComment(new MemoComment("c0000", "zzimnii", null, "memo1댓글작성!", 'Y', "20221117"), "m00001");
//		dao.addSubmitComment(new SubmitComment("c0000", "zzimnii", "submit2댓글작성1", 'Y', null, "20221117"), "s0000002");
//		ArrayList<MemoComment> mc = (ArrayList) dao.getMemoCommentList("m00001");
//		ArrayList<SubmitComment> sc = (ArrayList) dao.getSubmitCommentList("s0000002");
//		
//		System.out.println(mc.get(3).getCommentContents());
//		System.out.println(sc.get(0).getCommentContents());
	}
}
