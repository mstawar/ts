<%-- 
    Document   : bookList
    Created on : 2019-04-10, 22:35:26
    Author     : xxx
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ksiazki</title>
    </head>
    <body>
        <h1>Lista ksiazek</h1>
        <table style="width:50%" border="1">
            <tr>
                <th> ID </th>
                                <th> title </th>

                                                <th> author </th>

                                                                <th> isbn </th>
                                                                                <th> description </th>
 
            </tr>
                 <%
                    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
                    if(bookList !=null){
                        for(Book book : bookList){
                            
                     
                            %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getIsbn() %></td>
                <td><%= book.getShortDescription()%></td>
            </tr>
            <%
                   }
                    }
                %>
            
        </table>
    </body>
</html>
