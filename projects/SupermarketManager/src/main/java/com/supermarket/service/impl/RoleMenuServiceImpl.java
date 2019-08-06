package com.supermarket.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.supermarket.dao.RoleMenuDao;
import com.supermarket.entity.RoleMenu;
import com.supermarket.service.RoleMenuService;
@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {
	@Resource
	private RoleMenuDao roleMenuDao;
	
	public List<RoleMenu> isRoleIdExistence(Integer roleId) {
		return roleMenuDao.isRoleIdExistence(roleId);
	}

	public int deleteRoleId(Integer roleId) {
		return roleMenuDao.deleteRoleId(roleId);
	}

	public int add(RoleMenu roleMenu) {
		return roleMenuDao.add(roleMenu);
	}

}
