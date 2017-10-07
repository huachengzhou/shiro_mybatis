package com.blake.entiyi;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Role implements Serializable {
	private Integer rid; // ���
	private String role_name; // ��ɫ��ʶ �������ж�ʹ��,��"admin"
	private String description; // ��ɫ����,UI������ʾʹ��
	private Boolean available = Boolean.FALSE; // �Ƿ����,��������ý�������Ӹ��û�
	private Set<Privilege> privileges = new HashSet<Privilege>();
	private Set<User> users = new HashSet<User>();

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", role_name=" + role_name + ", description=" + description + ", available="
				+ available + "]";
	}

}
