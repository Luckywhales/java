package com.supermarket.service;

import com.supermarket.entity.UserRole;

public interface UserRoleService {

	UserRole findAll(String userName);

	Integer add(UserRole userRole);

	Integer delete(Integer id);

}
