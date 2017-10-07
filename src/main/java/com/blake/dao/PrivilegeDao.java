package com.blake.dao;

import java.util.Map;

import com.blake.entiyi.Privilege;

public interface PrivilegeDao {

	public void addPrivilege(Privilege privilege);

	public void removePrivilege(Integer pid);

	public void updatePrivilege(Privilege privilege);

	/** 总记录数 */
	public Long getLongNumber();

	@Deprecated
	public Privilege getPrivilege(Integer pid);

	public Privilege findPrivilege(Integer pid);

	/*------------------------------------分割线----------------------------------------*/
	
	/**关联表的插入var:rid pid*/
	public void addRole_Privilege(Map<String,Object> map);
	
	/**关联表的删除var:rid pid*/
	public void removeRole_Privilege(Map<String,Object> map);
	
	/**关联表的修改var:rid pid -->Privilege*/
	public void updateRole_Privilege_P(Map<String,Object> map);
	
	/**关联表的修改var:rid pid -->Role*/
	public void updateRole_Privilege_R(Map<String,Object> map);
}
