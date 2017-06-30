package springmvc.start.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import springmvc.start.domain.Product;
import springmvc.start.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private Map<Long, Product> products =new HashMap<Long,Product>();//数据库数据的保存与获取
	private AtomicLong generator =new AtomicLong();
	
	public  ProductServiceImpl() {
		Product product =new Product();
		product.setName("MiBook");
		product.setDescription("MiBook write code is very cool!");
	    product.setPrice(4999.0d);
	    add(product);
	}
	
	@Override
	public Product add(Product product) {
		long newid = generator.incrementAndGet();
		product.setId(newid);
		
		//保存到MAP中，此步骤模拟数据保存到数据库
		products.put(newid, product);
		return product;
	}

	@Override
	public Product get(long id) {
		return products.get(id);
	}

}
