package fi.taponen.productcatalogservice.domain;

public class CatalogItem {
	
	private String name;
	private String manufacturer;
	private String description;
	private int rating;
	
	
	public CatalogItem() {
		super();	
	}
	
	public CatalogItem(String name, String manufacturer, String description, int rating) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.rating = rating;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}


}
