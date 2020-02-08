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
        <h1><u>fill the form to register</u></h1>
        <div>
                <form action="/OrimyTeaShop/registration" method="GET">
                    <table>
                        <tr>
                            <td>enter username: </td>
                            <td><input type="text" class="form-control" name="username" placeholder="username"></td>
                        </tr>
                        <tr>
                            <td>enter password: </td>
                            <td><input type="text" class="form-control" name="password" placeholder="password"></td>
                        </tr>
                        <tr>
                            <td>enter email: </td>
                            <td><input type="text" class="form-control" name="email" placeholder="email"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="btn-success" type="submit" value="register me"></td>
                        </tr>
                    </table>
                </form>
        </div>    
    </body>
</html>
