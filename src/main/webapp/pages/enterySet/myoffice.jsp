<%@page import="java.util.List"%>
<%@page import="enteties.UserPurchase"%>
<%@page import="controller.PurchaseHandler"%>
<%@page import="controller.UserHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orimy-Tea-Shop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="shortcut icon" type="image/x-icon" 
              href="https://black-green.ru/fotos/object_main19.jpg">
        <style>
            table{
                 width: 1000px; /* Ширина таблицы */
                 border: 1px solid green; /* Рамка вокруг таблицы */
                 margin: auto; /* Выравниваем таблицу по центру окна  */
            }
            td{
                text-align: center; /* Выравниваем текст по центру ячейки */
            }
            body {
                background: url(https://us.123rf.com/450wm/skpuen/skpuen1706/skpuen170600011/80474686-abstract-grey-background-gray-texture-graphic-geometric-modern-silver-light-gradient-on-white-backgr.jpg?ver=6) no-repeat;
                -moz-background-size: 100%; /* Firefox 3.6+ */
                -webkit-background-size: 100%; /* Safari 3.1+ и Chrome 4.0+ */
                -o-background-size: 100%; /* Opera 9.6+ */
                background-size: 100%; /* Современные браузеры */
            }
        </style>
    </head>
    <body>
        <center><h1><u>my accaunt</u></h1></center> 
        
          <form action="/OrimyTeaShop/deposit" method="Post">
            <table>
                <tr>
                    <th>user: <%= (new UserHandler()).getUserName(request, "username") %></th>
                    <th><p>wallet: <%= (new UserHandler()).getUserWallet(request)%></p></th>
                    <th></th>
                </tr>
                <tr>
                    <% %>
                    <th>replenish account: </td>
                    <th>
                        <input type="text" class="form-control" name="total" placeholder="replenish account">
                    </th>
                    <th><input class="btn-success" type="submit" value="deposit to account"></th>
                </tr>
            </table>
          </form>
        
        <center>            
          <form action="/OrimyTeaShop/pages/products/products.jsp" method="GET">
            <input class="btn-success" type="submit" value="products">
          </form>
        </center>
            
        <center><h1><u>List of my purchases</u></h1></center>    
        <table border="1">
              <tbody>
                <tr>
                    <td>username</td>
                    <td>title</td>
                    <td>image</td>
                    <td>amount</td>
                    <td>total price</td>
                    <td>date</td>
                    <td></td>
                </tr>
                <%  String un = (new UserHandler()).getUserName(request, "username");
                    for(UserPurchase prod : new PurchaseHandler().listOfPurchases(un)){%>
                <tr>
                    <td><%= prod.getUsername() %></td>
                    <td><%= prod.getTitle() %></td>
                    <td><img src=<%= prod.getImg() %> width="300" height="200"/></td>
                    <td><%= prod.getAmount() %></td>
                    <td><%= prod.getmTotalPrice() %></td>
                    <td><%= prod.getDate() %></td>
                    <td>
                        <form action="/OrimyTeaShop/chooseProduct" method="GET">
                            <input type="hidden" name="productId" value=<%=prod.getmProductId()%>>
                            <input class="btn-success" type="submit" value="choose">
                        </form>
                    </td>
                </tr>
                <% } %>
              </tbody>
            </table>    
            
            
    </body>
</html>
