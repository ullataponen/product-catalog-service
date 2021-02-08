package fi.taponen.productcatalogservice.domain;

public class CatalogItem {

	private long id;
	private String name;
	private String manufacturer;
	private int rating;
	private String comment;
	
	
	public CatalogItem() {
		super();	
	}

	public CatalogItem(String name, String manufacturer, int rating) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.rating = rating;
	}
	
	public CatalogItem(long id, String name, String manufacturer, int rating, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.rating = rating;
		this.comment = comment;
	}

	public CatalogItem(String name, String manufacturer, int rating, String comment) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.rating = rating;
		this.comment = comment;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getmanufacturer() {
		return manufacturer;
	}


	public void setmanufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
