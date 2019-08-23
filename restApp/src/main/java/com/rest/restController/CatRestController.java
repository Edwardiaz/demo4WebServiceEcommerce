package com.rest.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	@RequestMapping("/")
	@ResponseBody
	public String MainPage() {
		return "Categoria.";
	}
	
	//metodo insertar
	@RequestMapping()
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
	
	
}
