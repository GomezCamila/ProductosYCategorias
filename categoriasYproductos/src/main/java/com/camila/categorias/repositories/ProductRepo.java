package com.camila.categorias.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camila.categorias.models.CategoryModel;
import com.camila.categorias.models.ProductModel;

@Repository
public interface ProductRepo extends CrudRepository<ProductModel, Long> {
 
	List<ProductModel> findAll();
//	List<ProductModel> fndByCategoriesNotContains(CategoryModel categoria);
	List<ProductModel> findByCategoriesNotContains(CategoryModel categoria);
	
}
