package cn.mybatis.po;
/**
 *ͨ������ӳ�䶩�����û���ѯ�Ľ�����ô���̳а��� �ֶν϶��pojo��
 */
public class OrdersCustom extends Orders {

	// ����û�����
	/*
	 * USER.username, USER.sex, USER.address
	 */
	private String username;
	private String sex;
	private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public OrdersCustom() {
	}
	@Override
	public String toString() {
		return "OrdersCustom [username=" + username + ", sex=" + sex + ", address=" + address + "]";
	}
}
