package controller;

import enteties.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHandler {
    private PreparedStatement pst;
    private final Connection con;
    private ResultSet rs;
    private final String username;
    private String query;

    public UserHandler(String username) throws ClassNotFoundException, SQLException {
        this.username = username;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orimy", "root", "1111");
    }
    
    public String getUserWallet() throws SQLException{
        query = "SELECT wallet FROM orimy.users WHERE username = '"+username+"';";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        rs.next();
        return rs.getString("wallet");
    }
    public void addToDB(User user) throws ClassNotFoundException, SQLException{
        query = "INSERT INTO `users` (`username`,`password`,`email`,`wallet`) "+ "VALUES ('"
                           +user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+
                                                                   "','"+user.getWallet()+"');";
        pst = con.prepareStatement(query);
        pst.executeUpdate();
    }
    
    public boolean userCheck(String username, String password) throws ClassNotFoundException, SQLException{
        
        query = "SELECT * FROM orimy.users WHERE username = '"+username+"'"
                                                                        + " AND password = '"+password+"';";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        rs.next();
        return rs.getString("username").equals(username)&rs.getString("password").equals(password);
    }
    
    public void deleteUser(String username){
    }
}

