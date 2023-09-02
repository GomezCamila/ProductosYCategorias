package com.camila.categorias.repositories;


import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camila.categorias.models.CategoryModel;
import com.camila.categorias.models.ProductModel;


@Repository
public interface CategoryRepo extends CrudRepository<CategoryModel, Long> {

	List<CategoryModel>findAll();
	//List<CategoryModel> findByProductsNotContains(Long idProduct);
	List<CategoryModel> findByProductsNotContains(ProductModel producto);
	
}
