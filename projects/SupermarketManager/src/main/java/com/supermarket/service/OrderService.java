package com.supermarket.service;

import java.util.List;
import java.util.Map;

import com.supermarket.entity.Order;
import com.supermarket.entity.Supplier;

public interface OrderService {

	public Order getTodayMaxNumber();

	public List<Order> findAll(Map<String, Object> map);

	public Long count(Map<String, Object> map);
	
	public Integer add(Order order);

	public int delete(Integer id);

	public int update(Order order);

}
