package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ws.dao.InterfaceProductsDao;
import com.ws.entity.Products;

public class ProductsServiceImpl implements ProductsService{

	@Autowired
	private InterfaceProductsDao proDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Products> findAll(){
		return (List<Products>)proDao.findAll();
	}
}
