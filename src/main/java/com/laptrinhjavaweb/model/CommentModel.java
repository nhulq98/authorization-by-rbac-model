package com.laptrinhjavaweb.model;

public class CommentModel extends AbstractModel{
	
	private String content;
	private long userId;
	private long newId;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getNewId() {
		return newId;
	}
	public void setNewId(long newId) {
		this.newId = newId;
	}
	
	
}

