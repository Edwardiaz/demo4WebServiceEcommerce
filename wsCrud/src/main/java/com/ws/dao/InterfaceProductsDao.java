package com.ws.dao;

import org.springframework.data.repository.CrudRepository;

import com.ws.entity.Products;

public interface InterfaceProductsDao extends CrudRepository<Products, Long> {

}
