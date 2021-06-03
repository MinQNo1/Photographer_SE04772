<%-- 
    Document   : error2
    Created on : Jun 3, 2021, 5:54:32 PM
    Author     : QuyenNV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/app.css" rel="stylesheet" type="text/css"/>
        <link href="css/error.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="header.jsp" />
        <div class="container-fluid content-wrapper">
            <div class="container">
                <div class="error"><h3>${error}</h3></div>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
