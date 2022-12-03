package model.service;

import java.sql.SQLException;
import java.text.ParseException;
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
	
	public GroupDAO getGroupDAO() {
		return this.groupDao;
	}
	
	//그룹 생성이랑 그룹 생성한 사람 그 그룹에 가입시키는 트랜잭션
	public int create(StudyGroup newGroup, String userId) throws SQLException, ExistingGroupException {
		StudyGroup studyGroup = null;
		
		studyGroup = check(newGroup.getGroupName(), newGroup.getCode());
		if(studyGroup != null)
			throw new ExistingGroupException();
		return groupDao.create(newGroup, userId);
	}
	
	
	public void addMember(Join join) {
		try {
			groupDao.addMember(join);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//회원이 가입한 그룹 리스트
	public List<Join> getUserGroupList(String userId) throws SQLException {
			List<Join> userGroupList = new ArrayList<>();
			userGroupList = groupDao.getMyGroup(userId);
			return userGroupList;
	}
	
	//그룹 이름으로 그룹 검색
	public StudyGroup getGroup(String groupName) throws SQLException{
		StudyGroup group = groupDao.search(groupName);
		return group;
	}
	
	//그룹 아이디로 그룹 검색
	public StudyGroup getGroupById(String groupId) throws SQLException{
		StudyGroup group = groupDao.search(groupId);
		return group;
	}
	
	//멤버 이름으로 해당 그룹원 검색
	public List<Member> search(String memberName, String groupId) throws SQLException{
		List<Member> memberList = new ArrayList<>();
		try {
			memberList = groupDao.searchMemberByName(memberName, groupId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}
	
	//그룹에 가입시 해당하는 코드가 맞는지 체크
	public StudyGroup check(String groupName, String code) throws SQLException{
		StudyGroup group = getGroup(groupName);
		if(group!=null && group.getCode().equals(code))
			return group;
		else
			return null;
	}
}
