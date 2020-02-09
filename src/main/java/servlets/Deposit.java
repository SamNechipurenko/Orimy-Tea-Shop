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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                    throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String username = request.getParameter("username");
            String deposit = request.getParameter("total");
            new UserHandler(username).depositAccaunt(deposit);
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/pages/enterySet/myoffice.jsp").forward(request, response);
        
        }catch(IOException ex){
            out.println(ex);
        } catch (ServletException ex) {
            out.println(ex);
        } catch (ClassNotFoundException ex) {
            out.println(ex);
        } catch (SQLException ex) {
            out.println(ex);
        }
    }

}
