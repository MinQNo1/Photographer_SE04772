<%-- 
    Document   : header.jsp
    Created on : May 18, 2021, 5:37:13 PM
    Author     : QuyenNV
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/app.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="header">
            <div class="link">
                <div class="container">
                    <a href="home">My font page</a>
                    <c:forEach items="${galleries}" var="i">
                        <a href="picture?id=${i.getId()}">${i.getName()}</a>
                    </c:forEach>
                    <a href="contact">Contact</a>
                </div>
            </div>
            <div class="title">
                <div class="container">
                    <a href="home"><div class="webTitle">
                            <img src="image/logo.jpg">
                            PHOTOGRAPHER
                        </div>
                    </a>
                    <h2>Welcome to Gallery website</h2>
                </div>
            </div>
        </div>    
    </body>
</html>
