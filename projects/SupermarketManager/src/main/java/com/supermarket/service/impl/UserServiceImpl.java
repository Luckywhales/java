package com.supermarket.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.supermarket.dao.UserDao;
import com.supermarket.entity.User;
import com.supermarket.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	
	@Resource
	private UserDao userDao;
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	public List<User> findAll(Map<String, Object> map) {
		return userDao.findAll(map);
	}

	public Long count(Map<String, Object> map) {
		return userDao.count(map);
	}

	public void add(User user) {
		userDao.add(user);
	}

	public void delete(Integer id) {
		userDao.delete(id);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void updateReset(Integer id) {
		userDao.updateReset(id);
	}

}
