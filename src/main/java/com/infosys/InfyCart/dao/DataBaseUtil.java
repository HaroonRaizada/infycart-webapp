package com.infosys.InfyCart.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class DataBaseUtil {
	private static final DataBaseUtil dataBaseUtil = new DataBaseUtil();
	private Connection connection;
	private static Logger logger= Logger.getLogger(DataBaseUtil.class);
	
	private DataBaseUtil()	{
		Properties prop = new Properties();
		String configFile = "dbconfig.properties";
		
		//loading db specific configuration info
		try(InputStream input = DataBaseUtil.class.getClassLoader().getResourceAsStream(configFile);) {
			prop.load(input);
		}
		catch(IOException exc){
			logger.error("Could not load dbconfig properties file");
		}
		String dburl = prop.getProperty("dburl");
		String dbname = prop.getProperty("dbusername");
		String dbpassword = prop.getProperty("dbpassword");
		
		//establishing connection
		try	{
			connection = DriverManager.getConnection(dburl,dbname,dbpassword);
		}
		catch(SQLException exc)		{
			logger.error("Connection could not be established successfully. Please check for the connection parameters");
		}
	}
	public Connection availConnection(){
		return connection;
	}
	public static DataBaseUtil getInstance(){
		return dataBaseUtil;
	}
	
}
