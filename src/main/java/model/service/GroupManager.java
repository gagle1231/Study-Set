package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Join;
import model.Member;
import model.StudyGroup;
import model.dao.GroupDAO;

public class GroupManager {
	private static GroupManager groupManager = new GroupManager();
	private GroupDAO groupDao;
	
	private GroupManager() {
		try {
			groupDao = new GroupDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static GroupManager getInstance() {
		return groupManager;
	}
	
	public int createGroup(GroupDAO newGroup) throws ExistingUserException, SQLException {
		//구현 필요
		return 0;
	}
	
	public List<Join> getUserGroupList(String userId) throws SQLException {
			List<Join> userGroupList = new ArrayList<>();
			userGroupList = groupDao.getMyGroup(userId);
			return userGroupList;
	}
	
	public StudyGroup getGroup(String groupName) throws SQLException{
		StudyGroup group = groupDao.search(groupName);
		return group;
	}
	public GroupDAO getGroupDAO() {
		return this.groupDao;
	}
	
	//이름으로 그룹원 검색
	public List<Member> search(String memberName, String groupId){
		List<Member> memberList = new ArrayList<>();
		try {
			memberList = groupDao.searchMemberByName(memberName, groupId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}
}
