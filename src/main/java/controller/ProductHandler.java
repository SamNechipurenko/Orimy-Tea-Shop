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
    private final Connection CON;
    private PreparedStatement pst;
    
    public ProductHandler() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        CON = DriverManager.getConnection ("jdbc:mysql://localhost:3306/orimy"
                                + "?useUnicode=true&characterEncoding=UTF-8", "root", "1111");
    }
    
    public List<Product> productList() throws SQLException{
        List<Product> products = new ArrayList<Product>();
        String query = "SELECT * FROM orimy.products;";
        pst = CON.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Product product = new Product(rs.getString("id"),rs.getString("title"),
                rs.getString("image"),rs.getString("country"), rs.getString("price"), 
                                     rs.getString("amount"), rs.getString("description"));
            products.add(product);
        }
        return products;
    }
    
    public Product getProduct(String id) throws SQLException{
        String query = "SELECT * FROM orimy.products WHERE id = '"+id+"';";
        pst = CON.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return new Product(rs.getString("id"), rs.getString("title"), rs.getString("image"),
                      rs.getString("country"), rs.getString("price"), rs.getString("amount"),
                                                                rs.getString("description"));
    }
    
    public List<Product> getUserPurcheses(String username) throws SQLException{
        String query = "SELECT * FROM orimy.purcheses WHERE username = '"+username+"';";
        pst = CON.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return null;
    }
    
    public void buyProduct(String id, String amount, String username) throws SQLException{
        //UPDATE tovar SET price=price*2;
        String priceQuery = "SELECT * FROM orimy.products WHERE id = '"+id+"';";
        pst = CON.prepareStatement(priceQuery);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String price = rs.getString("price");
        
        String query = "UPDATE orimy.products SET amount=amount-" +amount+" WHERE `id`='"+id+"';";
        pst = CON.prepareStatement(query);
        pst.executeUpdate();
        query = "UPDATE orimy.users SET wallet=wallet-"+amount+"*"+price+" WHERE `username`='"+username+"';";
        pst = CON.prepareStatement(query);
        pst.executeUpdate();
    }
}
