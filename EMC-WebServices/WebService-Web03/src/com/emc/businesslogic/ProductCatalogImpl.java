package com.emc.businesslogic;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogImpl {
	List<String> list = new ArrayList<String>();

	public ProductCatalogImpl(){
		System.out.println("Setting Initial products");
		list.add("Laptop");
		list.add("Chair");
		list.add("Bottle");

	}
	public List<String> getProducts(){
		// this should come from DB 
		return list;
	}
	
	public boolean addProduct(String productName){
		return list.add(productName);
	}
	
	
}
