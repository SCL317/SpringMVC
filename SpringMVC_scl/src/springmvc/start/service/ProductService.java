package springmvc.start.service;

import springmvc.start.domain.Product;

public interface ProductService {

	Product add(Product product);
	Product get(long id);
}
