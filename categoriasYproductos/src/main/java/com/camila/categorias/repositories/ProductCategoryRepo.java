package com.camila.categorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camila.categorias.models.ProductCategoryModel;

@Repository
public interface ProductCategoryRepo extends CrudRepository<ProductCategoryModel,Long>{

	//ProductCategoryModel saveAll(ProductCategoryModel union);

}
