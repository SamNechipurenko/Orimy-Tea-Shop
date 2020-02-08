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
            body {
                background: url(https://c.o0bg.com/rf/image_1200w/Boston/2011-2020/2018/11/26/BostonGlobe.com/Lifestyle/Images/RinaldiFoxHunt108.jpg) no-repeat;
                -moz-background-size: 100%; /* Firefox 3.6+ */
                -webkit-background-size: 100%; /* Safari 3.1+ и Chrome 4.0+ */
                -o-background-size: 100%; /* Opera 9.6+ */
                background-size: 100%; /* Современные браузеры */
            }
        </style>
    </head>
    <body>
        my accaunt. 
        <p>user: <%= request.getParameter("username")%></p>
        <p>wallet: <%= (new UserHandler(request.getParameter("username"))).getUserWallet()%></p>
        my purchases
        <form action="products" method="GET">
            <input type="hidden" name="username" value=${username}>
            <input class="btn-success" type="submit" value="products">
        </form>
    </body>
</html>
