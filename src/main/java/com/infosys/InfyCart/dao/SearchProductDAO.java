package com.infosys.InfyCart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SearchProductDAO {
	List<String> productList = new ArrayList<>();
	private Logger logger = Logger.getLogger(SearchProductDAO.class);

	public List<String> getAllProducts() {
		
		Connection con = DataBaseUtil.getInstance().availConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = con.createStatement();
			rs = stat.executeQuery("select productName from product");
			while (rs.next()) {
				productList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
			finally{
				try {
					if (stat != null) {
						stat.close();
					}
				} catch (SQLException e) {
					logger.error(e);
				}
			}
		}
		return productList;
	}

	public String getProductsById(int prodId) {
		Connection con = DataBaseUtil.getInstance().availConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = con.prepareStatement("select productName from product where productId=?");
			stat.setInt(1, prodId);
			rs = stat.executeQuery();

			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			logger.error(e);
		} 
		finally{
			try {
				if (stat != null) {
					stat.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		return null;
	}
}
