package com.blake.service;

import java.util.List;
import java.util.Set;

import com.blake.base.BaseService;
import com.blake.entiyi.User;
import com.blake.entiyi.page.PageResult_User;

public interface UserService extends BaseService<User> {
	/** ���ݴ��뼯��id��ȡUser List */
	public List<User> findUsers_Number(List<Integer> uids);

	/** ����ֻ����username,�����username��password������ */
	public User loginUser(String username);

	/** ��ȡ���н�ɫ */
	public Set<String> findRoles(String username);

	/** ��ȡ����Ȩ�� */
	public Set<String> findPermissions(String username);
	
	/**��ҳ*/
	public PageResult_User getPage(Integer pageNumber);
	
	/**������Ĳ��� var:rid and uid*/
	public void addRole_User(Integer uid,Integer rid);

}
