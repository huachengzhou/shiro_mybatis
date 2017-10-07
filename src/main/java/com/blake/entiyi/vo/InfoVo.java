package com.blake.entiyi.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blake.entiyi.Info;

public class InfoVo extends Info {
	/**
	 * 
	 */
	private static final long serialVersionUID = -939106651009027988L;
	private List<Integer> ids = new ArrayList<Integer>();
	private String organizationid;// ¹«Ë¾
	private String username;
	private String password;
	private String salt;
	private boolean lock;
	private Date time;
	private int uid;
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
	public boolean isLock() {
		return lock;
	}
	public void setLock(boolean lock) {
		this.lock = lock;
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
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	@Override
	public String toString() {
		return "InfoVo [organizationid=" + organizationid + ", username=" + username + ", password=" + password
				+ ", salt=" + salt + ", lock=" + lock + ", time=" + time + ", uid=" + uid + "]";
	}
}
