package servlets;

import controller.UserHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Deposit extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                                    throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            //Cookie[] cookies = request.getCookies();
            String deposit = request.getParameter("total");
            new UserHandler().depositAccaunt(deposit , request);
            
            response.sendRedirect("pages/enterySet/myoffice.jsp");
        }catch(IOException ex){
            out.println(ex);
        } catch (ClassNotFoundException ex) {
            out.println(ex);
        } catch (SQLException ex) {
            out.println(ex);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("pages/enterySet/myoffice.jsp");
    }

}
