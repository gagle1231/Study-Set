package model;

import java.io.Serializable;

public class Join implements Serializable{

	private String userId;
	private String groupId;
	private String groupName;
	
	public Join(String userId, String groupId, String groupName) {
		super();
		this.userId = userId;
		this.groupId = groupId;
		this.groupName = groupName;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
