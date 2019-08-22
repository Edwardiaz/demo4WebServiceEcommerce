package com.rest.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dao.ProductsDao;
import com.rest.entity.Products;

@RestController
public class ProdRestController {

	    @Autowired
	    private ProductsDao proDao;
	 
	    @RequestMapping("/")
	    @ResponseBody
	    public String welcome() {
	        return "Bienvenido.";
	    }
	    
	    // http://localhost:8090/restApp/producto
	    // http://localhost:8090/restApp/producto.json
	    @RequestMapping(value = "/producto", //
	            method = RequestMethod.GET, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public List<Products> getProducts() {
	        List<Products> list = proDao.consultarProductos();
	        return list;
	    }
	 
	    
	    // http://localhost:8090/restApp/producto/{id}
	    // http://localhost:8090/restApp/producto/{id}.json
	    @RequestMapping(value = "/producto/{id}", //
	            method = RequestMethod.GET, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public Products getProduct(@PathVariable("id") Long id) {
	        return proDao.findByIdProducto(id);
	    }
	 
	    // http://localhost:8090/restApp/producto
	    // http://localhost:8090/restApp/producto.json
	    @RequestMapping(value = "/producto", //
	            method = RequestMethod.POST, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public Products addProduct(@RequestBody Products pro) {
	 
	        return proDao.insertarProducto(pro);
	 
	    }
	 
	    // http://localhost:8090/restApp/producto
	    // http://localhost:8090/restApp/producto.json
	    @RequestMapping(value = "/producto/{id}", //
	            method = RequestMethod.PUT, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public Products updateProduct(@RequestBody Products id) {
	 
	        return proDao.updateProducto(id);
	    }
	 
	    // http://localhost:8090/restApp/producto/{id}
	    @RequestMapping(value = "/producto/{id}", //
	            method = RequestMethod.DELETE, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public void deleteProduct(@PathVariable("id") long id) {
	        proDao.eliminarProducto(id);
	    }
	}
