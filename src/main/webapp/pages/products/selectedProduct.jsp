<%@page import="controller.ProductHandler"%>
<%@page import="enteties.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orimy-Tea-Shop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="shortcut icon" type="image/x-icon" 
              href="https://black-green.ru/fotos/object_main19.jpg">
        
    </head>
    <body>
        <center><h1><u>List of our products</u></h1></center>
            <table border="1">
              <tbody>
                <tr>
                    <td>id</td>
                    <td>title</td>
                    <td>country</td>
                    <td>image</td>
                    <td>price</td>
                    <td>amount</td>
                    <td>description</td>
                    <td></td>
                </tr>
                <% String id = request.getParameter("productId");
                   Product prod = new ProductHandler().getProduct(id);%>
                <tr>
                    <td><%= prod.getId() %></td>
                    <td><%= prod.getTitle() %></td>
                    <td><%= prod.getCountry() %></td>
                    <td><img src=<%= prod.getImg() %> width="300" height="200"/></td>
                    <td><%= prod.getPrice() %></td>
                    <td><%= prod.getAmount() %></td>
                    <td><%= prod.getDescription() %></td>
                    <td>
                        <form action="buyProduct" method="GET">
                            <input type="hidden" name="username" value=<%=request.getParameter("username")%>>
                            <input type="text" class="form-control" name="amount" placeholder="grams of tea">
                            <input type="hidden" name="productId" value=<%=prod.getId()%>>
                            <input class="btn-success" type="submit" value="buy">
                        </form>
                    </td>
                </tr>
              </tbody>
            </table>
    </body>
</html>
