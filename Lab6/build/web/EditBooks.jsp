<%-- 
    Document   : EditBooks
    Created on : 2019-04-10, 23:09:54
    Author     : xxx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="EditBooks" method="POST">
            Enter id : <input type="text" name="id"><br>
            Enter title : <input type="text" name="title"><br>
            Enter author  : <input type="text" name="author"><br>
            Enter isbn : <input type="text" name="isbn"><br>
            Enter short description : <input type="text" name="shortDescription"><br>
            <input type="submit" value="edit">
            </form>
    </body>
</html>
