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

import com.rest.dao.ProductsCategoryDao;
import com.rest.entity.ProductsCategory;

@RestController
public class ProdCatRestController {

	@Autowired
	private ProductsCategoryDao proCatDao;
	
	@RequestMapping("/procat/main")
	@ResponseBody
	public String MainPage() {
		return "Products Categoy id table";
	}
	
	@RequestMapping(value = "/procat", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ProductsCategory saveProdCat(@RequestBody ProductsCategory proCat) {
		return proCatDao.saveProCat(proCat);
	}
	
	@RequestMapping(value = "/procat", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<ProductsCategory> findAllProCat(){
		List<ProductsCategory> listProCat = proCatDao.findAllProCat();
		return listProCat;
	}
	
	@RequestMapping(value = "/procat/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ProductsCategory findByIdProCat(@PathVariable("id") Long id) {
		return proCatDao.findByIdProCat(id);
	}
	
	@RequestMapping(value = "/procat/{id}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ProductsCategory updateProCat(@RequestBody ProductsCategory id) {
		return proCatDao.updateCategory(id);
	}
	
	@RequestMapping(value = "/procat", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public void deleteProCat(@PathVariable("id") long id) {
		proCatDao.deleteProCat(id);
	}
}
