package com.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rest.config.HibernateUtil;
import com.rest.entity.ProductsCategory;

@Repository
public class ProductsCategoryDao {

	JdbcTemplate template;
	
	public ProductsCategory saveProCat(ProductsCategory proCat) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(proCat);
			transaction.commit();
			return proCat;
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			System.out.println("ERROR ::::: "+e);
			return null;
		}
	}
	public List<ProductsCategory> findAllProCat(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from ProductsCategory", ProductsCategory.class).list();
		}
	}
	
	public ProductsCategory findByIdProCat(Long id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			ProductsCategory proCat = session.get(ProductsCategory.class, new Long(id));
			return proCat;
		}
	}
	
	public void deleteProCat(long id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProductsCategory proCat = session.load(ProductsCategory.class, new Long(id));
		transaction = session.beginTransaction();
		if(null != proCat) {
			session.delete(proCat);
			transaction.commit();
		}
	}
	
	public ProductsCategory updateCategory(ProductsCategory proCat) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.update(proCat);
			transaction.commit();
			return proCat;
		}
	}
}
