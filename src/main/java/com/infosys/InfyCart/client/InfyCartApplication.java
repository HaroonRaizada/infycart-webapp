package com.infosys.InfyCart.client;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.infosys.InfyCart.dao.DataBaseUtil;

public class InfyCartApplication {
private static Logger logger= Logger.getLogger(InfyCartApplication.class);
    
    public static void main(String[] args) throws Exception    {
        
        Connection connection=getConnection();
        if(connection !=null )
        	logger.info("Connection established");
        
    }
     //loading log4j.properties to do logging
     static void init() {
        PropertyConfigurator.configure("log4j.properties");
    }
     public static Connection getConnection(){
    	 Connection connection = DataBaseUtil.getInstance().availConnection();
    	 return connection;
     }
}
