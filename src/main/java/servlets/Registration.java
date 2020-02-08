package servlets;

import controller.UserHandler;
import enteties.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String username = request.getParameter("username"),
                   password = request.getParameter("password"), email = request.getParameter("email");
            if(!"".equals(username) && !"".equals(password) && !"".equals(email)){
                UserHandler userHandler = new UserHandler(username);
                userHandler.addToDB(new User(username, password, email, "0"));
                response.sendRedirect("pages/enterySet/login.jsp");
            }else out.println("one of mandatory fields is not filled");
        }catch (IOException ex){
            out.println(ex);
        } catch (ClassNotFoundException ex) {
            out.println(ex);
        } catch (SQLException ex) {
            out.println(request.getParameter("email"));
            out.println(ex);
        }
    }
}

