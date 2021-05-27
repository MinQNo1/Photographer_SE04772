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
            <div class="title-wrapper">
                <div class="title-inner">
                    <a class="logo" href="http://us-123photo.simplesite.com/">
                        <img src="${imagePath}${setting.src}"></a>
                    <div class="title ">
                        <a class="title title-link" href="http://us-123photo.simplesite.com/">
                            ${setting.title}
                        </a> 
                    </div>
                    <!--</div>-->
                    <div class="subtitle">
                        ${setting.subTitle}
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
