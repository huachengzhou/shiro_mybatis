package cn.mybatis.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *¶þ¼¶»º´æ
 */
@SuppressWarnings("serial")
public class User implements Serializable{
	private int id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;
	private List<Orders> ordersList = new ArrayList<Orders>();
	
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User() {
	}
	public User(String username, String sex, Date birthday, String address) {
		this.username = username;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}
	public User(int id, String username, String sex, Date birthday, String address) {
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + ", ordersList=" + ordersList + "]";
	}
}
