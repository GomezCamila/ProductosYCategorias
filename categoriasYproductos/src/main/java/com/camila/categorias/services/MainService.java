package com.camila.categorias.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camila.categorias.repositories.CategoryRepo;
import com.camila.categorias.repositories.ProductCategoryRepo;
import com.camila.categorias.repositories.ProductRepo;


import com.camila.categorias.models.CategoryModel;
import com.camila.categorias.models.ProductCategoryModel;
import com.camila.categorias.models.ProductModel;
@Service
public class MainService {

	
	
	//INYECCIONES
	@Autowired
	private final ProductRepo productRepo;
	@Autowired
	private final CategoryRepo categoryRepo;
	@Autowired
	private final ProductCategoryRepo productcategoryRepo;
	@Autowired
	public MainService(ProductRepo productRepo, CategoryRepo categoryRepo,ProductCategoryRepo productcategoryRepo) {
		this.productRepo=productRepo;
		this.categoryRepo= categoryRepo;
		this.productcategoryRepo=productcategoryRepo;
		}
	
	
	//METODOS PARA CREAR
	
	public ProductModel crearProducto(ProductModel producto) {
		return productRepo.save(producto);
	}
	
	public CategoryModel crearCategoria(CategoryModel categoria) {
		return categoryRepo.save(categoria);
	}
	
	public ProductCategoryModel crearUnion(ProductCategoryModel union) {
		return productcategoryRepo.save(union);
	}
	//lectura
	
	
	public ProductModel unProducto(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	public List<ProductModel> todosProductos(){
		return productRepo.findAll();
	}
	public List<ProductModel> categoriaSinProducto(CategoryModel categoria){
		return productRepo.findByCategoriesNotContains(categoria);
	}
	public CategoryModel unaCategoria(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}

	public List<CategoryModel> productoSinCategoria(ProductModel producto){
		return categoryRepo.findByProductsNotContains(producto);
	}

	
	


}
