package com.blake.dao;

import java.util.List;
import java.util.Map;

import com.blake.entiyi.User;
import com.blake.entiyi.page.PageResult_User;

public interface UserDao {
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public int addUser(User user);

	public User getUser(Integer uid);
	
	public User findUsersRolePrivilege(Integer uid);

	public void updateUser(User user);

	public void deleteUser(Integer uid);

	/** var:uids */
	public void deletesUser(Map<String, Object> map);

	public List<User> getUsers();

	/** var:uids */
	public List<User> findUsers_Number(Map<String, Object> map);

	/** 可以只传入username,最好是username与password都传入 */
	public User loginUser(User user);
	
	public Long getLongNumber();
	
	public List<User> getPages(PageResult_User page);
}
