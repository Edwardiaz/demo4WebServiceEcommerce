package com.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rest.entity.Products;
import com.rest.config.HibernateUtil;

@Repository
public class ProductsDao {

JdbcTemplate template;
	
	/*metodo insertar*/
	public Products insertarProducto(Products pro) {
		Transaction transaccion = null;
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			transaccion = sesion.beginTransaction();
			sesion.save(pro);
			transaccion.commit();
			return pro;
		} catch (Exception e) {
			
			if(transaccion != null) {
				transaccion.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}
	/*Termina metodo insertar*/
	
	/*metodo consultarAll*/
	public List<Products> consultarProductos(){
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			return sesion.createQuery("from Products", Products.class).list();	
		}
	}
	/*Teminar metodo consultarAll*/
	
	/*metodo consultarById*/
	public Products findByIdProducto(long id){
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			Products pro = (Products) sesion.get(Products.class, new Long(id));
			return pro;
		}
	}
	/*Teminar metodo consultarById*/
	
	/*Metodo Eliminar*/
	public void eliminarProducto(long id) {
		Transaction transaccion = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Products pro = (Products) sesion.load(Products.class, new Long(id));
		transaccion = sesion.beginTransaction();
		if (null != pro) {
			sesion.delete(pro);
			transaccion.commit();
		}
	}
	/*Termina metodo eliminar*/
	
	/*Metodo actualizar*/
	public Products updateProducto(Products pro) {
//		Transaction transaccion = null;
////		Session sesion = this.sessionFactory.getCurrentSession();
//		Session sesion = HibernateUtil.getSessionFactory().openSession();
//		Products pro = (Products) sesion.load(Products.class, id);
//		transaccion = sesion.beginTransaction();
//		if (null != pro) {
//			sesion.update(pro);
//			transaccion.commit();
//		}
//		return pro;
		
		Transaction transaccion = null;
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			transaccion = sesion.beginTransaction();
			sesion.update(pro);
			transaccion.commit();
			return pro;
		}
		
	}
	/*Terminar metodo Actulizar*/

}
