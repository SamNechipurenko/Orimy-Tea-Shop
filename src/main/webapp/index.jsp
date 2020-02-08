<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orimy Tea Shop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="shortcut icon" type="image/x-icon" href="https://www.rishi-tea.com/images/uploads/429_563_popup.jpg">
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
        <center><h1><u>log in</u></h1></center>
        <center> 
            <div>
                <form action="login" method="POST">
                    <table>
                        <tr>
                            <td>user name: </td>
                            <td><input type="text" class="form-control" name="username" placeholder="user name"></td>
                        </tr>
                        <tr>
                            <td>password: </td>
                            <td><input type="text" class="form-control" name="password" placeholder="password"></td>
                        </tr>
                        <tr>
                            <td><input class="btn-success" type="button" value="register" 
                                          accept="" onClick='location.href="pages/enterySet/register.jsp"'></td>
                            <td><input class="btn-success" type="submit" value="login"> </td>
                        </tr>
                    </table>
                </form>    
            </div>
        </center>
    </body>
</html>
