package servlets;

import controller.ProductHandler;
import controller.PurchaseHandler;
import cookiesOps.CookiesMethods;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                                    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String amount = request.getParameter("amount");
            String username =  new CookiesMethods().getCookie("username", request).getValue();
            String productId =  new CookiesMethods().getCookie("productId", request).getValue();
            new PurchaseHandler().addPurchase(username, productId, amount);
            new ProductHandler().buyProduct(productId, amount, username);
            
            response.sendRedirect("pages/enterySet/myoffice.jsp");
            
        }catch(IOException ex){
            out.println(ex);
        } catch (ClassNotFoundException ex) {
            out.println(ex);
        } catch (SQLException ex) {
            out.println(ex);
        }
    }
}
