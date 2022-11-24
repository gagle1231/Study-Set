package model;

import java.io.Serializable;

public class MemoComment implements Serializable{
	
	private String commentId;
	private String userId;
	private String memoId;
	private String commentContents;
	char annonymous;
	private String memoDate;
	
	
	public MemoComment(String commentId, String userId, String memoId, String commentContents, char annonymous, String memoDate) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.memoId = memoId;
		this.commentContents = commentContents;
		this.annonymous = annonymous;
		this.memoDate = memoDate;
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
	public String getMemoId() {
		return memoId;
	}
	public void setMemoId(String memoId) {
		this.memoId = memoId;
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
	public String getMemoDate() {
		return memoDate;
	}
	public void setMemoDate(String memoDate) {
		this.memoDate = memoDate;
	}
}
