package com.camila.categorias.models;
import java.util.Date;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="productos")
public class ProductModel {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	@NotBlank(message="Ingrese el nombre del producto")
	    private String name;
	 	@NotBlank(message="Ingrese una descripcion sobre el producto")
	    private String description;
	 	
	    private double price;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "productos_y_categorias", 
	        joinColumns = @JoinColumn(name = "product_id"), 
	        inverseJoinColumns = @JoinColumn(name = "category_id")
	    )
	    private List<CategoryModel> categories;
	    
	
	
	
	
	
	//CONSTRUCTOR
/*	public ProductModel(Long id, String name,String description, double price, Date createdAt, Date updatedAt) {
		this.id=id;
		this.name=name;
		this.description=description;
		this.price=price;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
        
}*/
	
	public ProductModel() {
		
	}
	
	
	
	
	
	
	//GETTERS Y SETTERS

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	


	public double getPrice() {
		return price;
	}








	public void setPrice(double price) {
		this.price = price;
	}








	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public List<CategoryModel> getCategories() {
		return categories;
	}








	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}








	@PrePersist
	protected void createdAt() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
}
}