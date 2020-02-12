package controller;

import controller.interfaces.PurchaseControl;
import enteties.UserPurchase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHandler implements PurchaseControl{
    private final Connection CON;
    private PreparedStatement ps;
    private ResultSet rs;
    public PurchaseHandler() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        CON = DriverManager.getConnection ("jdbc:mysql://localhost:3306/orimy?"
                               + "useUnicode=true&characterEncoding=UTF-8", "root", "1111");
    }
    
    @Override
    public void addPurchase(String username, String teaId, String amount) 
                                                throws ClassNotFoundException, SQLException{
        //java.time.LocalDate.now()
        String addPurchaseQuery = "INSERT INTO purchases (`purchaseID`,`username`,`teaId`,"
          + "`date`,`amount`) VALUES ('"+getPurchaseId()+"', '"+username+"', '"+teaId+"', '"
                                              +java.time.LocalDate.now()+"', '"+amount+"')";
        ps = CON.prepareStatement(addPurchaseQuery);
        ps.executeUpdate();
    }
    
    @Override
    public List<UserPurchase> listOfPurchases(String username) throws SQLException{
        List<UserPurchase> listOfPurchases = new ArrayList<UserPurchase>();
        String query = "SELECT * FROM purchases LEFT JOIN products ON "
              + "purchases.teaId=products.id WHERE purchases.username='"+username+"';";
        ps = CON.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            String title=rs.getString("products.title");
            String img=rs.getString("products.image");
            String amount=rs.getString("purchases.amount");
            String price=rs.getString("products.price");
            String date=rs.getString("purchases.date");
            String mProductId = rs.getString("products.id");
            float mTotalPrice = Float.valueOf(amount)*Float.valueOf(price);
            listOfPurchases.add(new UserPurchase(username, title, img, 
                                                        amount, mTotalPrice, date, mProductId));
        }
        return listOfPurchases;
    }
    
    @Override
    public void deletePurchase(String username, String teaId){
    }
    
    private int getPurchaseId() throws ClassNotFoundException, SQLException{
        int i = 0;
        String query = "SELECT * FROM orimy.purchases;";
        ps = CON.prepareStatement(query);
        rs = ps.executeQuery();
        String id;
        try {
            while(rs.next()) i++;
            return i+1;
        }catch (SQLException ex){
            return 1;
        }
    }
}
