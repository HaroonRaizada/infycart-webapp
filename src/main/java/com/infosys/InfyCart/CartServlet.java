package com.infosys.InfyCart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.infosys.InfyCart.service.SearchProductService;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CartServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> prodList = new SearchProductService().getAllProducts();
		response.setContentType("text/html");
		try {
			response.getWriter().println("<h3>The products available are:" + prodList + "</h3>");
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int prodId=0;
		try{
			prodId = Integer.parseInt(request.getParameter("txt_prod"));
		}
		catch(Exception e){
			logger.error(e);
		}
		String prodName = new SearchProductService().getProductsById(prodId);
		try {
			response.getWriter().println("<h3>The name of the product is:" + prodName + "</h3>");
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
