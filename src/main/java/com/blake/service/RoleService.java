package com.blake.service;

import com.blake.base.BaseService;
import com.blake.entiyi.Role;
import com.blake.entiyi.page.PageResult_Role;

public interface RoleService extends BaseService<Role> {
	
	public Integer addRoleInteger(Role role);
	/**·ÖÒ³*/
	public PageResult_Role getPage(Integer pageNumber);
}
