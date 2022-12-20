package model;

import java.io.Serializable;

public class Dues implements Serializable{
	
	private String duesId;
	private String groupId;
	private String duesDate;
	private int price;
	private String userName;
	
	public Dues(String duesId, String groupId, String duesDate, int price, String userName) {
		super();
		this.duesId = duesId;
		this.userName = userName;
		this.groupId = groupId;
		this.duesDate = duesDate;
		this.price = price;
	}
	
	public String getDuesId() {
		return duesId;
	}
	public void setDuesId(String duesId) {
		this.duesId = duesId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserId(String userName) {
		this.userName = userName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getDuesDate() {
		return duesDate;
	}
	public void setDuesDate(String duesDate) {
		this.duesDate = duesDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}