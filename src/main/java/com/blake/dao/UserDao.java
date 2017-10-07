package com.blake.dao;

import java.util.List;
import java.util.Map;

import com.blake.entiyi.User;
import com.blake.entiyi.page.PageResult_User;

public interface UserDao {
	/**
	 * ����û�
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

	/** ����ֻ����username,�����username��password������ */
	public User loginUser(User user);
	
	public Long getLongNumber();
	
	public List<User> getPages(PageResult_User page);
}
