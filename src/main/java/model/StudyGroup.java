package model;

import java.io.Serializable;

public class StudyGroup implements Serializable{

	private String groupId;
	private String groupName;
	private int groupCategory;
	private String groupDescription;
	private String code;
	
	public StudyGroup(String groupId, String groupName, int groupCategory, String groupDescription, String code) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupCategory = groupCategory;
		this.groupDescription = groupDescription;
		this.code = code;
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
	public int getGroupCategory() {
		return groupCategory;
	}
	public void setGroupCategory(int groupCategory) {
		this.groupCategory = groupCategory;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
