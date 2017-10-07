package com.blake.dao;

import java.util.Map;

import com.blake.entiyi.Privilege;

public interface PrivilegeDao {

	public void addPrivilege(Privilege privilege);

	public void removePrivilege(Integer pid);

	public void updatePrivilege(Privilege privilege);

	/** �ܼ�¼�� */
	public Long getLongNumber();

	@Deprecated
	public Privilege getPrivilege(Integer pid);

	public Privilege findPrivilege(Integer pid);

	/*------------------------------------�ָ���----------------------------------------*/
	
	/**������Ĳ���var:rid pid*/
	public void addRole_Privilege(Map<String,Object> map);
	
	/**�������ɾ��var:rid pid*/
	public void removeRole_Privilege(Map<String,Object> map);
	
	/**��������޸�var:rid pid -->Privilege*/
	public void updateRole_Privilege_P(Map<String,Object> map);
	
	/**��������޸�var:rid pid -->Role*/
	public void updateRole_Privilege_R(Map<String,Object> map);
}
