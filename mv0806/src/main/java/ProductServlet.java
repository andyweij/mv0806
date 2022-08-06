

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet( urlPatterns={"/ProductDAO"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {

    }
    public ArrayList  prepareArrayList(){
        ArrayList list ;
        ProductDAO dao=new ProductDAO();
        list=dao.getProductList();
        return list;
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=getServletContext(); 
	    ArrayList list=prepareArrayList();
	    request.setAttribute("catalog" , list);
	    RequestDispatcher  forwardPage = request.getRequestDispatcher("Show.jsp");
	    try {
	    	forwardPage.forward(request , response);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
