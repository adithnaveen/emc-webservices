package com.emc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emc.businesslogic.ProductCatalogImpl;

/**
 * Servlet implementation class ProductViewController
 */
@WebServlet("/ProductView")
public class ProductViewController extends HttpServlet {

	ProductCatalogImpl catalog;
	public void init(){
		System.out.println("Init called in product view>>>>>>>>>>");
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		catalog = (ProductCatalogImpl) getServletContext().getAttribute("CATALOG");
		
		request.setAttribute("PRODUCTS", catalog.getProducts());
		request.getRequestDispatcher("/WEB-INF/views/ShowAllProducts.jsp")
				.forward(request, response);
	}

}
