package com.blake.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blake.dao.RoleDao;
import com.blake.entiyi.Role;
import com.blake.entiyi.page.PageResult_Role;
import com.blake.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void add(Role entity) {
		System.out.println("Ö÷¼ü:"+roleDao.addRole(entity));
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void update(Role entity) {
		roleDao.updateRole(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void remove(Serializable id) {
		roleDao.removeRole((Integer) id);
	}

	public Role findObjectById(Serializable id) {
		Integer rid = (Integer) id;
		Role role = roleDao.findRoleById(rid);
		if (role==null) {
			role = roleDao.findRoleID(rid);
		}
		return role;
	}

	public List<Role> findObjects() {
//		return roleDao.findRolesUserPrivilege();
		return roleDao.findRolePrivilege();
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void removes(Serializable[] ids) {
		List<Integer> integers = new ArrayList<Integer>();
		for (Serializable integer : ids) {
			integers.add((Integer) integer);
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rids",map);
		roleDao.removeRoles(map);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public Integer addRoleInteger(Role role) {
		return roleDao.addRole(role);
	}

	public PageResult_Role getPage(Integer pageNumber) {
		Long totalCount = roleDao.getLongNumber();
		PageResult_Role page = new PageResult_Role();
		page.setTotalCount(roleDao.getLongNumber());
		page.setPageNumber(Long.valueOf(pageNumber));
		List<Role> roles = roleDao.getPageRoles(page);
		page.setItems(roles);
		page.setTotalCount(totalCount);
		return page;
	}
}
