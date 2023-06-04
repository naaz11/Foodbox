package com.foodbox.restbackend.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
	//Properties
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="producyId")    
	private Long id;
	@Column(name="productImageUrl")
	private String productImageUrl;
	@Column(name="productName")
	private String productName;
	@Column(name="productPrice")
	private float productPrice;
	@Column(name="productRating")
	private float productRating;
	@Column(name="tags")
    public String tags[];
    @Column(name="cuisines")
    public String cuisines[];
	
	//Default Constructor
	public Product () {
		
	}
	
	//Parameterized Constructor
	public Product(String productImageUrl, String productName, float productPrice, float productRating, String tags[], String cuisines[]) {
		this.productImageUrl = productImageUrl;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productRating = productRating;
		this.tags = tags;
		this.cuisines = cuisines;
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	
	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public float getProductRating() {
		return productRating;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String[] getCuisines() {
		return cuisines;
	}

	public void setProductCuisines(String[] Cuisines) {
		this.cuisines = Cuisines;
	}

	//Other Methods
	@Override
	public String toString() {
		return "Product [id=" + id + ", productImageUrl=" + productImageUrl + ", productName=" + productName + ", productPrice=" + productPrice
				 + ", productRating=" + productRating + ", tags=" + tags + ", cuisines=" + cuisines + "]";
	}



}
