package com.supermarket.service;

import java.util.List;
import java.util.Map;

import com.supermarket.entity.Supplier;

public interface SupplierService {

	Long count(Map<String, Object> result);

	List<Supplier> findAll(Map<String, Object> result);

	Supplier findRepeat(String name);

	int add(Supplier supplier);

	int update(Supplier supplier);

	int delete(Integer id);

}
