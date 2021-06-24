
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/app.css" rel="stylesheet" type="text/css"/>
        <link href="css/contact.css" rel="stylesheet" type="text/css"/>
        <title>Contact</title>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="header.jsp" %>
            <div class="content-wrap">
                <div class="left-area">
                    <div class="large-title">Contact</div>
                    <div class="contact-title">Photographer</div>
                    <div class="contact">Address :   ${contact.address}</div>
                    <div class="contact" >City :   ${contact.city}</div>                   
                    <div class="contact">Country :   ${contact.country}</div>
                    <div class="contact mt-25">Tel :   ${contact.tel}</div>
                    <div class="contact mt-15">Email :   ${contact.email}</div>
                    <img class="mt-70" src="${imagePath}${map}" alt="map">
                </div>
                <div class="right-area">
                    <%@include file="right.jsp"%>
                </div>
            </div>
            <footer>
                <%@include file="footer.jsp"%>
            </footer>
        </div>  
    </body>
</html>
