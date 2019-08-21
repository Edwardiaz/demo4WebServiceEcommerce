package com.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws.dao.InterfaceProductsDao;
import com.ws.entity.Products;

@Service
public interface ProductsService {

//	@Autowired
////	@Qualifier(value = "proDao")
//	InterfaceProductsDao proDao;
	
//	public static void save(Products products) {
//        proDao.save(products);
//    }
//     
//    public static List<Products> listAll() {
//        return (List<Products>) proDao.findAll();
//    }
//     
//    public static Products get(Long id) {
//        return proDao.findById(id).get();
//    }
//     
//    public static void delete(Long id) {
//        proDao.deleteById(id);
//    }
	
	List<Products> listAll();
     
}
