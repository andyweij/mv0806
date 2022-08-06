

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SimpleEmp;


/**
 * Servlet implementation class GetDataRows
 */
@WebServlet("/GetDataRows")
public class GetDataRows extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei";
        String username = "root";
        String password = "1234";
        PrintWriter out = response.getWriter();
        String city=request.getParameter("city");
        if(city==null||city=="") {
         city="NYC";
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            CallableStatement cStmt = con.prepareCall("{CALL GetEmployeeByCity(?)}");
            cStmt.setString(1, city);
            ResultSet rs=cStmt.executeQuery();
            print(out, rs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}

    public GetDataRows() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void fillList(ResultSet rs, ArrayList<SimpleEmp> list) {
        try {
            while (rs.next()) {
                SimpleEmp emp=new SimpleEmp(
                        rs.getInt("employeeNumber"),rs.getString("firstname"),
                        rs.getString("lastname"),rs.getString("email"));
                list.add(emp);
            }
        } catch (Exception ex) {
        }
    }
    public void print(PrintWriter out ,ResultSet rs)
    {       
        try {          
            out.println("<table border='1'>");
            while (rs.next()) {             
                out.println("<tr><td>");
                String no = rs.getString("employeeNumber");
                out.println(""+no);
                out.println("</td><td>");
                String firstname = rs.getString("firstname");
                out.println(""+firstname);
                out.println("</td><td>");
                String lastname = rs.getString("lastname");
                out.println(""+lastname);
                out.println("</td><td>");
                String email = rs.getString("email");
                 out.println(""+email);
                out.println("</td>");                
            }
            out.println("</table>");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
    
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	 public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>


}
