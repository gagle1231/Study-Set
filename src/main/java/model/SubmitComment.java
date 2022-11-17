package model;

import java.io.Serializable;

public class SubmitComment implements Serializable{
	
	private String commentId;
	private String userId;
	private String commentContents;
	char annonymous;
	private String submitId;
	private String commentDate;
	
	public SubmitComment(String commentId, String userId, String commentContents, char annonymous, String submitId,
			String commentDate) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.commentContents = commentContents;
		this.annonymous = annonymous;
		this.submitId = submitId;
		this.commentDate = commentDate;
	}
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentContents() {
		return commentContents;
	}
	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}
	public char getAnnonymous() {
		return annonymous;
	}
	public void setAnnonymous(char annonymous) {
		this.annonymous = annonymous;
	}
	public String getSubmitId() {
		return submitId;
	}
	public void setSubmitId(String submitId) {
		this.submitId = submitId;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
}
