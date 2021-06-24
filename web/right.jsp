<%-- 
    Document   : right.jsp
    Created on : May 20, 2021, 3:48:10 PM
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
        <div class="right-wrapper">
            <div class="right-title">Share this page</div>
            <div class="right-social">
                <div>
                    <img class="icon" src="${imagePath}${fb}" >
                    <a href="#" class="right-social social-link ">Share on Facebook</a>
                </div>
                <div>
                    <img class="icon" src="${imagePath}${tw}" >
                    <a href="#" class="right-social social-link ">Share on Twitter</a>
                </div>
                <div>
                    <img class="icon" src="${imagePath}${gg}" >
                    <a href="#" class="right-social social-link ">Share on Google+</a>
                </div>
            </div>
        </div>
    </body>
</html>
