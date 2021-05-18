<%-- 
    Document   : header.jsp
    Created on : May 18, 2021, 5:37:13 PM
    Author     : QuyenNV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="link">
                    <a href="home">My front page</a>
                    <c:forEach items="${galleries}" var="gallery">
                        <a class="${gallery.id == gId?"fontBold":""}" rel="nofollow"  href="picture?id=${gallery.id}">${gallery.name}</a>
                    </c:forEach>
                    <a href="contact">Contact</a>
                </div>
                <div class="title">
                    <a href="home"><div class="webTitle">
                            <img src="image/logo.jpg">
                            PHOTOGRAPHER
                        </div>
                    </a>
                    <h2>Welcome to this website</h2>
                </div>
            </div>
    </body>
</html>
