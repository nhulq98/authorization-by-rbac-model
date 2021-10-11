package com.laptrinhjavaweb.model;

public class UserModel extends AbstractModel{
	private String userName;
	private String password;
	private String fullName;
	private int status;
	private long roleId;
	private String roleCode;
	private RoleModel roleModel = new RoleModel();

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


	public RoleModel getRoleModel() {
		return roleModel;
	}
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

}
