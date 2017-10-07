package com.blake.service;

import java.util.List;
import java.util.Set;

import com.blake.base.BaseService;
import com.blake.entiyi.User;
import com.blake.entiyi.page.PageResult_User;

public interface UserService extends BaseService<User> {
	/** 根据传入集合id获取User List */
	public List<User> findUsers_Number(List<Integer> uids);

	/** 可以只传入username,最好是username与password都传入 */
	public User loginUser(String username);

	/** 获取所有角色 */
	public Set<String> findRoles(String username);

	/** 获取所有权限 */
	public Set<String> findPermissions(String username);
	
	/**分页*/
	public PageResult_User getPage(Integer pageNumber);
	
	/**关联表的插入 var:rid and uid*/
	public void addRole_User(Integer uid,Integer rid);

}
