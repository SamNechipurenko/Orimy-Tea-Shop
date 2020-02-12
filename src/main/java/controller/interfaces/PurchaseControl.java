package controller.interfaces;

import enteties.UserPurchase;
import java.sql.SQLException;
import java.util.List;

public interface PurchaseControl{
    
    public void addPurchase(String username, String teaId, String amount) 
                                                throws ClassNotFoundException, SQLException;
    
    public List<UserPurchase> listOfPurchases(String username) throws SQLException;
    
    public void deletePurchase(String username, String teaId);
    
}
