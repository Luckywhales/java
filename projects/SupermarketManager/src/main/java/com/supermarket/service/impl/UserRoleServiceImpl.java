package com.supermarket.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.supermarket.dao.UserRoleDao;
import com.supermarket.entity.UserRole;
import com.supermarket.service.UserRoleService;
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService{
	@Resource
	private UserRoleDao userRoleDao;
	public UserRole findAll(String userName) {
		return userRoleDao.findAll(userName);
	}

	public Integer add(UserRole userRole) {
		// TODO Auto-generated method stub
		return userRoleDao.add(userRole);
	}

	public Integer delete(Integer id) {
		return userRoleDao.delete(id);
	}

	


}
