package com.ws.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ws.entity.Products;
import com.ws.service.ProductsService;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class RestProductsController {

//		@Qualifier("ProductoService")
	@Autowired
	private ProductsService proService;

	private List<Products> listPro;

	@GetMapping(value = "productos", produces = "application/json")
	public @ResponseBody List<Products> index() {
		listPro = (List<Products>) proService.findAll();
		return listPro;
	}

//		@GetMapping(value="/productos", produces = "application/json")
//		public String index(){
//			return "listaC";
//		}

}
