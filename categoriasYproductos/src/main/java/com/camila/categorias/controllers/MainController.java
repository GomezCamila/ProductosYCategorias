package com.camila.categorias.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.camila.categorias.models.CategoryModel;
import com.camila.categorias.models.ProductModel;
import com.camila.categorias.services.MainService;
@SuppressWarnings("unused")
public class MainController {

	//INYECCION
	@Autowired
	private final MainService mainService;
	public MainController(MainService service) {
		this.mainService= service;
	}

	
	
	
	@GetMapping("/")
	public String root(Model modelo) {
		List<ProductModel> todosProductos = mainService.todosProductos();
	modelo.addAttribute("productos", todosProductos);
	return "index.jsp";
	
	}
	
}
