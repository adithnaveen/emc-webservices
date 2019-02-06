package com.emc;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.emc.businesslogic.ProductCatalogImpl;
import com.oracle.webservices.api.EnvelopeStyle.Style;

@WebService
public class ProductCatalog {
	
	ProductCatalogImpl productCatalog = new ProductCatalogImpl();
	
	public List<String> getProducts(){
		return productCatalog.getProducts();
	}

	public boolean addProduct(String productName){
		return productCatalog.addProduct(productName);
	}
}
