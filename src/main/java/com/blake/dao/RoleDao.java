package com.blake.dao;

import java.util.List;
import java.util.Map;

import com.blake.entiyi.Role;
import com.blake.entiyi.page.PageResult_Role;

public interface RoleDao {
	
	/**��ɫ������� */
	public Integer addRole(Role role);
	
	public void removeRole(Integer rid);
	
	public Role findRoleById(Integer rid);
	
	/**������ʹ��*/
	@Deprecated
	public Role findRoleID(Integer rid);
	
	/**������ʹ��*/
	@Deprecated
	public List<Role> findRolesUserPrivilege();
	
	public List<Role> findRolePrivilege();
	
	public List<Role> getPageRoles(PageResult_Role page);
	/**�ܼ�¼��*/
	public Long getLongNumber();
	
	/**"var: rids"*/
	public void removeRoles(Map< String,Object> map);
	
	public void updateRole(Role role);
	/*------------------------------------�ָ���------------------------------------------------*/
	/**������Ĳ��� var:rid and uid*/
	public void addRole_User(Map<String,Object> params);
	
	/**�������ɾ�� var:rid and uid:����������������������*/
	public void removeRole_User(Map<String,Object> params);
	
	/**��������޸� var:rid and uid:ֻ���ǲ���User���޸�Role��.....С��*/
	public void updateRole_User_U(Map<String,Object> params);
	
	/**��������޸� var:rid and uid:ֻ���ǲ���Role���޸�User�� ......С��*/
	public void updateRole_User_R(Map<String,Object> params);
}
