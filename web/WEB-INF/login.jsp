<%-- 
    Document   : login
    Created on : Nov 26, 2021, 4:35:55 PM
    Author     : 733357
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form method="post" action="login">
            username: <input type="text" required name="username"><br>
            password: <input type="password" required name="password"><br>
            <input type="submit" value="Submit">
            
        </form>
        
        <a href="forgot?action">Forgot Password</a>
    </body>
</html>