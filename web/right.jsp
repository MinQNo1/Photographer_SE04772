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
        <div class="right">
            <div class="share">
                <div class="sharePage">Share this page</div>
                <div class="shareContent">
                    <div class="fb">
                        <p><img class="shareItems" src="${imagePath}${fb}"><a class="text-white" href="#">Share on Facebook</a></p>
                    </div>
                    <div class="twitter">
                        <p><img class="shareItems" src="${imagePath}${tw}"><a class="text-white" href="#">Share on Twitter</a></p>
                    </div>
                    <div class="google">
                        <p><img class="shareItems" src="${imagePath}${gg}"><a class="text-white" href="#">Share on Google+</a></p>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
