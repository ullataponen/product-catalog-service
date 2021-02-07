package fi.taponen.productcatalogservice.domain;

public class Rating {
	
	private long productId;
	private int rating;
	private String comment;
	
	public Rating() {

	}

	public Rating(long productId, int rating) {
		super();
		this.productId = productId;
		this.rating = rating;
	}
	
	public Rating(long productId, int rating, String comment) {
		super();
		this.productId = productId;
		this.rating = rating;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
