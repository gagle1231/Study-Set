package model;

public class Submit {
	private String userId;
	private String filePath;
	private String submitContents;
	private String submitDate;
	private String taskId;
	private String submitId;

	public Submit(String userId, String filePath, String submitContents, String submitDate, String taskId,
			String submitId) {
		super();
		this.userId = userId;
		this.filePath = filePath;
		this.submitContents = submitContents;
		this.submitDate = submitDate;
		this.taskId = taskId;
		this.submitId = submitId;
	}

	public Submit(String submitContents) {
		super();
		this.submitContents = submitContents;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSubmitContents() {
		return submitContents;
	}

	public void setSubmitContents(String submitContents) {
		this.submitContents = submitContents;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getSubmitId() {
		return submitId;
	}

	public void setSubmitId(String submitId) {
		this.submitId = submitId;
	}

}
