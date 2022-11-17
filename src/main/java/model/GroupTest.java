package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import model.dao.GroupDAO;

public class GroupTest {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		GroupDAO dao = new GroupDAO();

//		dao.create(new StudyGroup(null, "알고리즘", 1, "알고리즘 스터디", "100100"));
		StudyGroup group = dao.search("알고리즘");
		

//		if (group != null) {
//			System.out.println("gId: " + group.getGroupId());
//			System.out.println("gName: " + group.getGroupName());
//			System.out.println("gCategory: " + group.getGroupCategory());
//			System.out.println("gDescription: " + group.getGroupDescription());
//			System.out.println("gCode: " + group.getCode());
//			System.out.println();
//		} else {
//			System.out.println("부서를 찾지 못했음");
		}
}
