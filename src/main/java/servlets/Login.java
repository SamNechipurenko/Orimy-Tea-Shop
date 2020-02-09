package servlets;

import controller.UserHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                       throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            try{
                if(true==(new UserHandler(username)).userCheck(username, password)){
                    request.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/pages/enterySet/myoffice.jsp").forward(request, response);
                }
            }catch (SQLException ex){
                out.println(username + password);
                    out.println("Incorrect username or password");
            }catch (ClassNotFoundException ex) {
                out.println();
            }
        }catch(IOException ex){
            out.println(ex);
        } catch (ServletException ex) {
            out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
}
