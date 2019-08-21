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
	 
	    // URL:
	    // http://localhost:8080/SpringMVCRESTful/employees
	    // http://localhost:8080/SpringMVCRESTful/employees.xml
	    // http://localhost:8080/SpringMVCRESTful/employees.json
	    @RequestMapping(value = "/find", //
	            method = RequestMethod.GET, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public List<Products> getProducts() {
	        List<Products> list = proDao.consultarProductos();
	        return list;
	    }
	 
	    // URL:
	    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}
	    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}.xml
	    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}.json
	    @RequestMapping(value = "/pro/{id}", //
	            method = RequestMethod.GET, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public Products getEmployee(@PathVariable("id") int id) {
	        return proDao.findByIdProducto(id);
	    }
	 
	    // URL:
	    // http://localhost:8080/SpringMVCRESTful/employee
	    // http://localhost:8080/SpringMVCRESTful/employee.xml
	    // http://localhost:8080/SpringMVCRESTful/employee.json
	    @RequestMapping(value = "/save", //
	            method = RequestMethod.POST, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public Products addEmployee(@RequestBody Products emp) {
	 
	        return proDao.insertarProducto(emp);
	 
	    }
	 
	    // URL:
	    // http://localhost:8080/SpringMVCRESTful/employee
	    // http://localhost:8080/SpringMVCRESTful/employee.xml
	    // http://localhost:8080/SpringMVCRESTful/employee.json
	    @RequestMapping(value = "/update", //
	            method = RequestMethod.PUT, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public Products updateEmployee(@RequestBody Products id) {
	 
	        return proDao.updateProducto(id);
	    }
	 
	    // URL:
	    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}
	    @RequestMapping(value = "/pro/{id}", //
	            method = RequestMethod.DELETE, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public void deleteEmployee(@PathVariable("empNo") int id) {
	        proDao.eliminarProducto(id);
	    }
	 
	}
