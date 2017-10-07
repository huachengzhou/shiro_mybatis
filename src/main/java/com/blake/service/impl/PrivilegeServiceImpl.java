package com.blake.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blake.dao.PrivilegeDao;
import com.blake.entiyi.Privilege;
import com.blake.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Autowired
	private PrivilegeDao privilegeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void add(Privilege entity) {
		privilegeDao.addPrivilege(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void update(Privilege entity) {
		privilegeDao.updatePrivilege(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void remove(Serializable id) {
		privilegeDao.removePrivilege((Integer) id);
	}

	public Privilege findObjectById(Serializable id) {
		return privilegeDao.findPrivilege((Integer) id);
	}

	@Override
	public List<Privilege> findObjects() {
		return null;
	}

	@Override
	public void removes(Serializable[] ids) {
		
	}

}
