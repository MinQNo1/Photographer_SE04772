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
        <title>Header</title>
    </head>
    <body>
        <div class="header-wrap">
            <div class="h-nav">
                <div class="h-nav-container">
                    <ul class="h-nav-menu">
                        <li><a class="${clicked=="home"?"clicked":""}" href="home">My front page</a></li>    
                        <c:forEach var="i" items="${top3}">
                            <li>
                                <a class="${id==i.id?"clicked":""}" href="picture?id=${i.id}">${i.name}</a>
                            </li>
                        </c:forEach>
                        <li><a class="${clicked=="contact"?"clicked":""}" href="contact">Contact</a></li>         
                    </ul>
                </div>
            </div>
            <div class="banner">
                <div class="banner-container">
                    <div class="banner-logo"><img src="${imagePath}${setting.src}"></div>
                    <div class="banner-text">
                        <div class="banner-text-large">Photographer</div>
                        <div class="banner-text-medium">Welcome to this website</div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
