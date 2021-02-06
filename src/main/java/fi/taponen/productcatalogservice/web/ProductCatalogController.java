package fi.taponen.productcatalogservice.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import fi.taponen.productcatalogservice.domain.CatalogItem;
import fi.taponen.productcatalogservice.domain.UserRating;
import fi.taponen.productcatalogservice.services.ProductInfo;
import fi.taponen.productcatalogservice.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class ProductCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	ProductInfo productInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		System.out.println("userid" + userId);
		
		UserRating userRating = userRatingInfo.getUserRating(userId);
		
		return userRating.getRatings().stream().map(rating -> {
			return productInfo.getCatalogItem(rating);
		}).collect(Collectors.toList());
	}
	
}
