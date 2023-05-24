<%-- 
    Document   : TestCart
    Created on : Mar 17, 2023, 8:09:07 PM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:forEach var="item" items="${sessionScope.cart}">
        ${item.Product.productId}
    </c:forEach>
    </body>
</html>
