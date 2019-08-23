package com.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rest.config.HibernateUtil;
import com.rest.entity.Category;

@Repository
public class CategoryDao {

	JdbcTemplate template;
	
	//metodo insertar
	public Category saveCategory(Category cat) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(cat);
			transaction.commit();
			return cat;
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}
	
	//metodo consultarAll
	public List<Category> findAll(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Category", Category.class).list();
		}
	}
	
	//metodo consultar por id
	public Category findByIdCategory(Long id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Category cat = (Category)session.get(Category.class, new Long(id));
			return cat;
		}
	}
	
	//metodo eliminar
	public void deleteCategory(long id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Category cat = (Category)session.load(Category.class, new Long(id));
		transaction = session.beginTransaction();
		if(null != cat) {
			session.delete(cat);
			transaction.commit();
		}
	}
	
	//metodo actualizar
	public Category updateCategory(Category cat) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.update(pro);
			transaction.commit();
			return cat;
		}
	}
}
