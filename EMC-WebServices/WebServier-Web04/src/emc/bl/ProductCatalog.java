package emc.bl;

import java.util.List;

import javax.jws.WebService;

import emc.bean.Product;

@WebService
public interface ProductCatalog {
	public boolean addProduct(int id, String name, String category);
	public String getProduct(int id);
	public List<Product> getAllProducts();
}
