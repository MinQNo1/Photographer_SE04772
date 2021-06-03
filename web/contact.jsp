
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
        <jsp:include page="header.jsp" />
        <div class="container">
            <div class="content">
                <div class="left">
                    <div class="">
                        <div class="titleContact">
                            <p>Contact</p><br>
                            PHOTOGRAPHER<br>
                        </div>
                        <div class="detailContact">
                            Address: ${contact.address}<br>
                            City: ${contact.city}<br>
                            Country: ${contact.country}<br><br>
                            Tel: ${contact.tel}<br>
                            Email: ${contact.email}<br>
                        </div>
                    </div>
                    <div class="">
                        <img src="images/map.jpg" width="700px" height="500px">
                    </div>
                </div>
                <jsp:include page="right.jsp" />
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
