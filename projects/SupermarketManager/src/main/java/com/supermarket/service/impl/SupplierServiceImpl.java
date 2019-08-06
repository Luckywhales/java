package com.supermarket.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.supermarket.dao.SupplierDao;
import com.supermarket.entity.Supplier;
import com.supermarket.service.SupplierService;
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
	@Resource
	private SupplierDao supplierDao;
	public Long count(Map<String, Object> map) {
		return supplierDao.count(map);
	}

	public List<Supplier> findAll(Map<String, Object> map) {
		return supplierDao.findAll(map);
	}

	public Supplier findRepeat(String name) {
		return supplierDao.findRepeat(name);
	}

	public int add(Supplier supplier) {
		return supplierDao.add(supplier);
	}

	public int update(Supplier supplier) {
		return supplierDao.update(supplier);
	}

	public int delete(Integer id) {
		return supplierDao.delete(id);
		
	}

}
