package com.camila.categorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.camila.categorias.models.ProductCategoryModel;
import com.camila.categorias.services.MainService;

@Controller
public class ProductCategoryController {

//INYECCIONES
	@Autowired
	private final MainService mainService;
	public ProductCategoryController(MainService service) {
		this.mainService=service;
	}
	@PostMapping("/aso/{idProducto}")
	public String asociarProductoCategoria(@PathVariable("idProducto")Long idProducto,
			@ModelAttribute("asociacion")ProductCategoryModel productosCategorias, BindingResult result, Model viewModel) {
	
	if(result.hasErrors()) {
		return "mostrarproductos.jsp";
	}
	
	
	mainService.crearUnion(productosCategorias);
	return "redirect:/products/"+idProducto;
			
		}
	
	@PostMapping("/ase/{idCategoria}")
	public String asociarProductoCategorias(@PathVariable("idCategoria")Long idCategoria,
			@ModelAttribute("asociaciones")ProductCategoryModel productosCategorias,
			Model viewModel, BindingResult result){
		if(result.hasErrors()) {
			return "mostrarproductos.jsp";
		}
	    mainService.crearUnion(productosCategorias);
	    return "redirect:/categories/"+idCategoria;
	
	
}
}
