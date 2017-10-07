package com.blake.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blake.dao.RoleDao;
import com.blake.dao.UserDao;
import com.blake.entiyi.Privilege;
import com.blake.entiyi.Role;
import com.blake.entiyi.User;
import com.blake.entiyi.page.PageResult_User;
import com.blake.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void add(User entity) {
		userDao.addUser(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void update(User entity) {
		userDao.updateUser(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void remove(Serializable id) {
		userDao.deleteUser((Integer) id);
	}

	public User findObjectById(Serializable id) {
		return userDao.getUser((Integer) id);
	}

	public List<User> findObjects() {
		return userDao.getUsers();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void removes(Serializable[] ids) {
		List<Integer> integers = new ArrayList<Integer>();
		for (Serializable integer : ids) {
			integers.add((Integer) integer);
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("uids",integers);
		userDao.deletesUser(map);
	}

	public List<User> findUsers_Number(List<Integer> uids) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("uids",uids);
		return userDao.findUsers_Number(map);
	}

	public User loginUser(String username) {
		User user = new User();
		user.setUsername(username);
		return userDao.loginUser(user);
	}

	public Set<String> findRoles(String username) {
		User user2 = loginUser(username);
		User user = userDao.findUsersRolePrivilege(user2.getUid());
		Set<Role> roles = user.getRoles();
		Set<String> rSet = new HashSet<String>();
		for (Role role : roles) {
			rSet.add(role.getRole_name());
		}
		return rSet;
	}

	public Set<String> findPermissions(String username) {
		User user2 = loginUser(username);
		User user = userDao.findUsersRolePrivilege(user2.getUid());
		Set<Role> roles = user.getRoles();
		Set<String> pSet = new HashSet<String>();
		for (Role role : roles) {
			Set<Privilege> privileges = role.getPrivileges();
			for (Privilege privilege : privileges) {
				pSet.add(privilege.getDescription());
			}
		}
		return pSet;
	}

	public PageResult_User getPage(Integer pageNumber) {
		Long totalCount = userDao.getLongNumber();
		PageResult_User page = new PageResult_User();
		page.setTotalCount(totalCount);
		page.setPageNumber(Long.valueOf(pageNumber));
		
		List<User> users = userDao.getPages(page);
		page.setItems(users);
		page.setTotalCount(totalCount);
		return page;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void addRole_User(Integer uid, Integer rid) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("uid",uid);
		map.put("rid",rid);
		roleDao.addRole_User(map);
	}

}
