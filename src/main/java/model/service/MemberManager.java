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
	
	public Member findUser(String userId)
		throws SQLException, UserNotFoundException {
		Member member = memberDao.findMember(userId);
		
		if (member == null) {
			throw new UserNotFoundException("존재하지 않는 아이디입니다.");
		}		
		return member;
	}

	public boolean login(String userId, String password)
			throws SQLException, UserNotFoundException, PasswordMismatchException {
			Member member = findUser(userId);

			if (!member.matchPassword(password)) {
				throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
			}
			return true;
		}


	public MemberDAO getMemberDAO() {
		return this.memberDao;
	}
}
