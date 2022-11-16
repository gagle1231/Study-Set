package model;

public class Task {
	private String taskId;
	private String name;
	private String startDate;
	private String endDate;
	private String description;
	
	
	public Task(String taskId, String name, String startDate, String endDate, String description) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
