package controller.interfaces;

import enteties.User;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public interface UserControl {
    public String getUserWallet(HttpServletRequest request) throws SQLException;
    public void addToDB(User user) throws ClassNotFoundException, SQLException;    
    public boolean userCheck(String username, String password) throws ClassNotFoundException, SQLException;
    public  void depositAccaunt(String total, HttpServletRequest request) throws SQLException;
    public String getUserName(HttpServletRequest request, String name);
    public void deleteUser(String username);
}
