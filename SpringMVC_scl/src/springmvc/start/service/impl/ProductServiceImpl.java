package springmvc.start.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import springmvc.start.domain.Product;
import springmvc.start.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private Map<Long, Product> products =new HashMap<Long,Product>();//���ݿ����ݵı������ȡ
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
		
		//���浽MAP�У��˲���ģ�����ݱ��浽���ݿ�
		products.put(newid, product);
		return product;
	}

	@Override
	public Product get(long id) {
		return products.get(id);
	}

}
