package com.camila.categorias.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 

import com.camila.categorias.models.CategoryModel;
import com.camila.categorias.models.ProductCategoryModel;
import com.camila.categorias.models.ProductModel;
import com.camila.categorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {

	//INYECCIONES
	@Autowired
	private final MainService mainService;
	
	public CategoryController(MainService service) {
		this.mainService= service;
	}
	
	@GetMapping("/")
	public String root(Model modelo) {
		List<ProductModel> todosProductos = mainService.todosProductos();
	modelo.addAttribute("productos", todosProductos);
	return "index.jsp";
	
	}
	
	@GetMapping("/categories/new")
	public String formProduct(@ModelAttribute("categoria")CategoryModel categoria) {
		return "nuevacategoria.jsp";
	}
	
	@PostMapping("/categories/new")
	public String nuevoProduct(@Valid @ModelAttribute("categoria")CategoryModel categoria, BindingResult result) {
		
	if(result.hasErrors()){
		return "nuevacategoria.jsp";
	}mainService.crearCategoria(categoria);
	return "redirect:/";
	}
	
	@GetMapping("/categories/{idCategoria}")
	public String mostrarProducto(@PathVariable("idCategoria")Long idCategoria,
			@ModelAttribute("asociaciones")ProductCategoryModel asociacion,
			Model modelo) {
		CategoryModel categoria = mainService.unaCategoria(idCategoria);
		modelo.addAttribute("productos", mainService.categoriaSinProducto(categoria));
		modelo.addAttribute("categoria", categoria);
	//System.out.println(categoria.getProducts().size());
		return "showC.jsp";
		
	}
	
}
