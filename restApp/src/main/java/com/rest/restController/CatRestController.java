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

import com.rest.dao.CategoryDao;
import com.rest.entity.Category;

@RestController
public class CatRestController {

	@Autowired
	private CategoryDao catDao;
	
	//metodo principal
	@RequestMapping("/categoria/main")
	@ResponseBody
	public String MainPage() {
		return "Categoria.";
	}
	
	//metodo insertar
	@RequestMapping(value = "/categoria", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Category saveCategory(@RequestBody Category cat) {
		return catDao.saveCategory(cat);
	}
	
	//metodo consultar todo
	@RequestMapping(value = "/categoria", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Category> findAll(){
		List<Category> listCat = catDao.findAll();
		return listCat;
	}
	
	//metodo consultar por id
	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Category findByIdCat(@PathVariable("id") Long id) {
		return catDao.findByIdCategory(id);
	}
	
	//metodo actualizar
	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Category updateCategory(@RequestBody Category id) {
		return catDao.updateCategory(id);
	}
	
	//metodo borrar
	@RequestMapping(value = "/categoria", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public void deleteCategory(@PathVariable("id") long id) {
		catDao.deleteCategory(id);
	}
}
