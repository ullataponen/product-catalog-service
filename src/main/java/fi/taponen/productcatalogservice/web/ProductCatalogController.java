package fi.taponen.productcatalogservice.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.taponen.productcatalogservice.domain.CatalogItem;
import fi.taponen.productcatalogservice.domain.UserRating;
import fi.taponen.productcatalogservice.services.ProductInfo;
import fi.taponen.productcatalogservice.services.UserRatingInfo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/catalog")
public class ProductCatalogController {
	

	@Autowired
	ProductInfo productInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		UserRating userRating = userRatingInfo.getUserRating(userId);
		
		return userRating.getRatings().stream().map(rating -> {
			return productInfo.getCatalogItem(rating);
		}).collect(Collectors.toList());
	}
	
}
