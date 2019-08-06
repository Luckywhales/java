package com.supermarket.service;

import java.util.List;
import java.util.Map;

import com.supermarket.entity.User;

public interface UserService {

	User findByUserName(String userName);

	List<User> findAll(Map<String, Object> result);

	Long count(Map<String, Object> result);

	void add(User user);

	void delete(Integer id);

	void update(User user);

	void updateReset(Integer id);
	

}
