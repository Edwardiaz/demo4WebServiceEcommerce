package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws.entity.Products;

@Service("proService")
public class ProductsServiceImpl implements ProductsService{

	@Autowired
	@Override
	@Transactional(readOnly = true)
	 public List<Products> listAll() {
        return (List<Products>) repo.findAll();
    }

}
