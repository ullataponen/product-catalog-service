package fi.taponen.productcatalogservice.domain;

public class Rating {
	
	private long productId;
	private int rating;
	
	public Rating() {
	}

	public Rating(long productId, int rating) {
		super();
		this.productId = productId;
		this.rating = rating;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
