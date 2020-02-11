<%@page import="cookiesOps.CookiesMethods"%>
<%@page import="controller.UserHandler"%>
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
        <center><h1><u>you choose</u></h1></center>
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
                <%  String id = (new CookiesMethods()).getCookie("productId", request).getValue();
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
                        <form action="/OrimyTeaShop/buyProduct" method="POST">
                            <input type="text" class="form-control" name="amount" placeholder="grams of tea">
                            <input class="btn-success" type="submit" value="buy">
                        </form>
                    </td>
                </tr>
              </tbody>
            </table>
    </body>
</html>
