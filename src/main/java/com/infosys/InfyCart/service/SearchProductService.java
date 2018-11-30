package com.infosys.InfyCart.service;

import java.util.List;
import com.infosys.InfyCart.dao.SearchProductDAO;

public class SearchProductService {
	public List<String> getAllProducts(){
		return new SearchProductDAO().getAllProducts();
	}
	 public String getProductsById(int prodId){
		 return new SearchProductDAO().getProductsById(prodId);
	 }
}
