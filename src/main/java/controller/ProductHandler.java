package controller;

import enteties.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductHandler {
    private final Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;
    
    public ProductHandler() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/orimy", "root", "1111");
    }
    
    public List<Product> productList() throws SQLException{
        List<Product> products = new ArrayList<Product>();
        query = "SELECT * FROM orimy.products;";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while(rs.next()){
            Product product = new Product(rs.getString("id"),rs.getString("title"),
                rs.getString("image"),rs.getString("country"), rs.getString("price"), 
                                     rs.getString("amount"), rs.getString("description"));
            products.add(product);
        }
        return products;
    }
    
    public Product getProduct(String id) throws SQLException{
        query = "SELECT * FROM orimy.products WHERE id = '"+id+"';";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        rs.next();
        return new Product(rs.getString("id"), rs.getString("title"), rs.getString("image"),
                      rs.getString("country"), rs.getString("price"), rs.getString("amount"),
                                                                rs.getString("description"));
    }
    
    public List<Product> getUserPurcheses(String username) throws SQLException{
        query = "SELECT * FROM orimy.purcheses WHERE username = '"+username+"';";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        rs.next();
        return null;
    }
    
    public void buyProduct(String id, String amount, String username) throws SQLException{
        //UPDATE tovar SET price=price*2;
        String priceQuery = "SELECT * FROM orimy.products WHERE id = '"+id+"';";
        ps = con.prepareStatement(priceQuery);
        rs = ps.executeQuery();
        rs.next();
        String price = rs.getString("price");
        
        query = "UPDATE orimy.products SET amount=amount-" +amount+" WHERE `id`='"+id+"';";
        ps = con.prepareStatement(query);
        ps.executeUpdate();
        query = "UPDATE orimy.users SET wallet=wallet-"+amount+"*"+price+" WHERE `username`='"+username+"';";
        ps = con.prepareStatement(query);
        ps.executeUpdate();
    }
}
