package model;

public class Member {

	private String userId;
	private String userName;
	private String pwd;
	private String phone;
	private String birth;
	private String email;
	
	
	public Member(String userId, String userName, String pwd, String phone, String birth, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
		this.phone = phone;
		this.birth = birth;
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean matchPassword(String pwd) {
		if (pwd == null) {
			return false;
		}
		return this.pwd.equals(pwd);
	}
	
	public boolean isSameUser(String userid) {
        return this.userId.equals(userid);
    }
}
