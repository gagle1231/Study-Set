package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Member;
import model.dao.*;

public class MemberManager {
	private static MemberManager memManager = new MemberManager();
	private MemberDAO memberDao;
	
	private MemberManager() {
		try {
			memberDao = new MemberDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MemberManager getInstance() {
		return memManager;
	}
	
	//아이디로 멤버 찾기
	public Member findUser(String userId)
		throws SQLException, UserNotFoundException {
		Member member = memberDao.findMember(userId);
		
		if (member == null) {
			throw new UserNotFoundException("존재하지 않는 아이디입니다.");
		}		
		return member;
	}

	//로그인 처리
	public Member login(String userId, String password)
			throws SQLException, UserNotFoundException, PasswordMismatchException {
			Member member = findUser(userId);

			if (!member.matchPassword(password)) {
				throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
			}
			
			return member;
		}

	//수정 필요
	public int createMember(Member newMember) throws ExistingUserException, SQLException {
		if (memberDao.existingUser(newMember.getUserId()) == true) {
			throw new ExistingUserException(newMember.getUserId() + "는 존재하는 아이디입니다.");
		}
		return memberDao.create(newMember);
	}
	
	public MemberDAO getMemberDAO() {
		return this.memberDao;
	}
	
	public List<Member> findMemberByName(String memberName) throws SQLException {
		
		return memberDao.findMemberByName(memberName);

	}
}
