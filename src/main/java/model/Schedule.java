package model;

public class Schedule {
	private String scheduleId;
	private String groupId;
	private String title;
	private String date;
	private String startTime;
	private String endTime;
	private String location;
	private String description;
	char important;
	

	
	public Schedule(String scheduleId, String groupId, String title, String date, String startTime, String endTime,
			String location, String description, char important) {
		super();
		this.scheduleId = scheduleId;
		this.groupId = groupId;
		this.title = title;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.description = description;
		this.important = important;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public char getImportant() {
		return important;
	}
	public void setImportant(char important) {
		this.important = important;
	}
	
}
