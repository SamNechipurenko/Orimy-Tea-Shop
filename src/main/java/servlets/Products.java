package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Products extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username =  (String) request.getParameter("username");
        request.setAttribute("username", username);
               getServletContext().getRequestDispatcher("/pages/products/products.jsp").forward(request, response);
    }
}
