package com.blake.dao;

import java.util.List;
import java.util.Map;

import com.blake.entiyi.Role;
import com.blake.entiyi.page.PageResult_Role;

public interface RoleDao {
	
	/**角色表的增加 */
	public Integer addRole(Role role);
	
	public void removeRole(Integer rid);
	
	public Role findRoleById(Integer rid);
	
	/**不建议使用*/
	@Deprecated
	public Role findRoleID(Integer rid);
	
	/**不建议使用*/
	@Deprecated
	public List<Role> findRolesUserPrivilege();
	
	public List<Role> findRolePrivilege();
	
	public List<Role> getPageRoles(PageResult_Role page);
	/**总记录数*/
	public Long getLongNumber();
	
	/**"var: rids"*/
	public void removeRoles(Map< String,Object> map);
	
	public void updateRole(Role role);
	/*------------------------------------分割线------------------------------------------------*/
	/**关联表的插入 var:rid and uid*/
	public void addRole_User(Map<String,Object> params);
	
	/**关联表的删除 var:rid and uid:最好是两个参数都传入最好*/
	public void removeRole_User(Map<String,Object> params);
	
	/**关联表的修改 var:rid and uid:只能是参照User表修改Role表.....小心*/
	public void updateRole_User_U(Map<String,Object> params);
	
	/**关联表的修改 var:rid and uid:只能是参照Role表修改User表 ......小心*/
	public void updateRole_User_R(Map<String,Object> params);
}
