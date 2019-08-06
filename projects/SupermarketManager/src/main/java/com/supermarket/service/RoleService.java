package com.supermarket.service;

import java.util.List;
import java.util.Map;

import com.supermarket.entity.Role;

public interface RoleService {

	List<Role> findAll(Map<String, Object> result);

	Long count(Map<String, Object> result);

	Role findRepeat(String roleName);

	int add(Role role);

	int delete(Integer id);

	int update(Role role);

}
