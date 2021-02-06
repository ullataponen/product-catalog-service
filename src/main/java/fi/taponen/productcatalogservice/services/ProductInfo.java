package fi.taponen.productcatalogservice.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import fi.taponen.productcatalogservice.domain.CatalogItem;
import fi.taponen.productcatalogservice.domain.Product;
import fi.taponen.productcatalogservice.domain.Rating;

@Service
public class ProductInfo {
	
	@Autowired
	private  RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            })
	public CatalogItem getCatalogItem(Rating rating) {
		Product product = restTemplate.getForObject("http://product-info-service/products/" + rating.getProductId(), Product.class);
		return new CatalogItem(product.getName(), product.getManufacturer(), rating.getRating());
	}

	public CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Product name not found", "", rating.getRating());
    }
}
