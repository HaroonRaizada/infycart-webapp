package com.infosys.InfyCart.client;

import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.infosys.InfyCart.service.SearchProductService;

public class SearchProductClient {
private static Logger logger= Logger.getLogger(SearchProductClient.class);

   private SearchProductClient(){
	   
   }
    public static void main(String[] args) throws Exception    {
    	
    	SearchProductService service=new SearchProductService();
    	List<String> prodList=service.getAllProducts();
    	logger.info(prodList+"\n");
    	
    	System.out.println("");
    	System.out.println("Enter the prodcutId to be searched:");
    	
    	int id=Integer.parseInt(new Scanner(System.in).nextLine());
    	logger.info("ProdctName is:"+service.getProductsById(id));
    }
}

