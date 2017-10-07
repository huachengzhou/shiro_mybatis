package com.blake.entiyi;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class User implements Serializable {

	private String organizationid;// 公司
	private String username;
	private String password;
	private String salt;
	private boolean lock_User;//不要写成lock
	private Date time;
	private int uid;
	private Set<Role> roles = new HashSet<Role>();// 拥有的角色列表

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}


	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public boolean isLock_User() {
		return lock_User;
	}

	public void setLock_User(boolean lock_User) {
		this.lock_User = lock_User;
	}

	@Override
	public String toString() {
		return "User [organizationid=" + organizationid + ", username=" + username + ", password=" + password
				+ ", salt=" + salt + ", lock_User=" + lock_User + ", time=" + time + ", uid=" + uid + "]";
	}
	
	
}
