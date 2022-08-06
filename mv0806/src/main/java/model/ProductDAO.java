package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {
	public ArrayList getProductList() {
        //Mysql DB Connection URL
        String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei&useUnicode=true&characterEncoding=utf8";
        String username = "admin";
        String password = "1234";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();
String query = "SELECT productCode  as  code , quantityInStock  as  quantity, productDescription  as  description,  buyPrice  as  price  FROM  Products  where buyPrice>=90.0 "; 
        try {    
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                product ur = new product();
                ur.setCode(rs.getString("code"));
                ur.setQuantity(rs.getInt("quantity"));
                ur.setDescription(rs.getString("description"));
                ur.setPrice(rs.getString("price"));
                list.add(ur);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
