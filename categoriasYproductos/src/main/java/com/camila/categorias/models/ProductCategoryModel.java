package com.camila.categorias.models;
import java.util.Date;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;





@Entity
@Table(name = "productos_y_categorias")
public class ProductCategoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductModel product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryModel category;


	//CONSTRUCTOR
/*	public ProductCategoryModel(Long id, Date createdAt, Date updatedAt, CategoryModel category, ProductModel product){
		this.id=id;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
		this.category=category;
		this.product=product;
	}*/
	public ProductCategoryModel() {
		
	}
	

//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
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
