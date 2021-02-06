package fi.taponen.productcatalogservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	private String name;
	private String manufacturer;
	
	public Product() {
	}

	public long getProductId() {
		return productId;
	}

	public Product(long productId, String name, String manufacturer) {
		super();
		this.productId = productId;
		this.name = name;
		this.manufacturer = manufacturer;
	}
	
	public Product(String name, String manufacturer) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
}
