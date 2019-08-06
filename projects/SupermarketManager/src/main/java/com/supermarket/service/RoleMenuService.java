package com.supermarket.service;

import java.util.List;

import com.supermarket.entity.RoleMenu;

public interface RoleMenuService {

	List isRoleIdExistence(Integer roleId);

	int deleteRoleId(Integer roleId);

	int add(RoleMenu roleMenu);

}
