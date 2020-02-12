package controller.interfaces;

import enteties.Product;
import java.sql.SQLException;
import java.util.List;

public interface ProductControl {
    public List<Product> productList() throws SQLException;
    public Product getProduct(String id) throws SQLException;
    public List<Product> getUserPurcheses(String username) throws SQLException;
    public void buyProduct(String id, String amount, String username) throws SQLException;
}
