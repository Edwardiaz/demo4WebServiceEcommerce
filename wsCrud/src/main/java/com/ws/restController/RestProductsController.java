package com.ws.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ws.entity.Products;
import com.ws.service.ProductsService;

@Controller
//@RequestMapping(value = "/api", method = RequestMethod.GET)
public class RestProductsController {

//	@GetMapping(value="/listaP", produces = "application/json")
//	public @ResponseBody List<Productos> consultarProducto() {
//		ProductDao proDao = new ProductoDao();
//
//		List<Products> listaPro = proDao.consultarProductos();
////		m.addAttribute("listaPro", listaPro);
//		return listaPro;
//	}
	
	@Autowired(required = true)
	
	private ProductsService proService;
	
	@GetMapping(value="/listaP", produces = "application/json")
	public @ResponseBody List<Products> home() {
	    List<Products> listCustomer = proService.listAll();
	    ModelAndView mav = new ModelAndView("index");
	    mav.addObject("listCustomer", listCustomer);
	    return listCustomer;
	}
}
