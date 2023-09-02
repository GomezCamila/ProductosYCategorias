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
@Table(name="categorias")
public class CategoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Ingrese una categoria")
	private String name;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "productos_y_categorias", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<ProductModel> products;

	
	
	
	//Constructor
/*	public CategoryModel(Long id, String name,Date createdAt, Date updatedAt) {
		this.id=id;
		this.name=name;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}*/
public CategoryModel() {
	
}

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


	public List<ProductModel> getProducts() {
		return products;
	}


	public void setProducts(List<ProductModel> products) {
		this.products = products;
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