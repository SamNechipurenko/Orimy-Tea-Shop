package servlets;

import controller.ProductHandler;
import enteties.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String username = request.getParameter("username");
            String productId = request.getParameter("productId");
            Product product = (new ProductHandler()).getProduct(productId);
            request.setAttribute("username", username);
            request.setAttribute("productId",productId);
            getServletContext().getRequestDispatcher("/pages/products/selectedProduct.jsp").
                                                                 forward(request, response);
        } catch (IOException ex){
            out.println(ex);
        } catch (ClassNotFoundException ex) {
            out.println(ex);
        } catch (SQLException ex) {
            out.println(ex);
        } catch (ServletException ex) {
            out.println(ex);
        }
    }
}
