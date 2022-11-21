package model;

public class TimeSlot {
	String timeSlotId;
	String userId;
	int day;
	int startTime;
	int endTime;
	String groupId;
	
	public TimeSlot() {
		super();
	}

	public TimeSlot(String timeslotId, String userId, int day, int startTime, int endTime, String groupId) {
		super();
		this.timeSlotId = timeslotId;
		this.userId = userId;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.groupId = groupId;
	}
	// groupId 뺸 생성자
	public TimeSlot(String timeSlotId, String userId, int day, int startTime, int endTime) {
		super();
		this.timeSlotId = timeSlotId;
		this.userId = userId;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	// groupId & userId 뺀 생성자
	public TimeSlot(String timeSlotId, int day, int startTime, int endTime) {
		super();
		this.timeSlotId = timeSlotId;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getTimeslotId() {
		return timeSlotId;
	}

	public void setTimeslotId(String timeslotId) {
		this.timeSlotId = timeslotId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "timeSlot [timeslotId=" + timeSlotId + ", userId=" + userId + ", day=" + day + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", groupId=" + groupId + "]";
	}

}