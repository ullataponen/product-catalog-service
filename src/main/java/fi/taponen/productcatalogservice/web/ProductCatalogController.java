package fi.taponen.productcatalogservice.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fi.taponen.productcatalogservice.domain.CatalogItem;
import fi.taponen.productcatalogservice.domain.Product;
import fi.taponen.productcatalogservice.domain.Rating;
import fi.taponen.productcatalogservice.domain.UserRating;

@RestController
@RequestMapping("/catalog")
public class ProductCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);

		return ratings.getUserRating().stream().map(rating -> {
			Product product = restTemplate.getForObject("http://product-info-service/products/" + rating.getProductId(), Product.class);
			
			return new CatalogItem(product.getName(), "Bosch", "Gets the job done", rating.getRating());
		}).collect(Collectors.toList());
}
	
}
