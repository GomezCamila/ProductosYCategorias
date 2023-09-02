package com.camila.categorias.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.camila.categorias.models.ProductCategoryModel;
import com.camila.categorias.models.ProductModel;
import com.camila.categorias.services.MainService;

import jakarta.validation.Valid;



@Controller
public class ProductController {

@Autowired
	private final MainService mainService;
	@Autowired
	
	public ProductController(MainService service) {
		this.mainService = service;
	}
	
	
	
	
	
	@GetMapping("/products/new")
	public String formProduct(@ModelAttribute("producto")ProductModel producto) {
		return "nuevoproducto.jsp";
	}
	
	
	@PostMapping("/products/new")
	public String nuevoProduct(@Valid @ModelAttribute("producto")ProductModel producto,
			BindingResult result) {
		if(result.hasErrors()) {
			return "nuevoproducto.jsp";
			
		}mainService.crearProducto(producto);
		return "redirect:/";
	}
	
	@GetMapping("/products/{idProduct}")
	public String mostrarProduct(@PathVariable("idProduct")Long idProduct,
			@ModelAttribute("asociacion")ProductCategoryModel asociocion,
			Model modelo) {
		ProductModel producto =mainService.unProducto(idProduct);
		modelo.addAttribute("categorias", mainService.productoSinCategoria(producto));
	    modelo.addAttribute("producto", producto);
	 //   System.out.println(producto.getCategories().size());
	    return "mostrarproductos.jsp";
	}
		
	}

