
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Contact</title>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="link">
                    <a href="home">My front page</a>
                     <c:forEach items="${galleries}" var="gallery">
                        <a class="${gallery.id == gId?"fontBold":""}" rel="nofollow" href="picture?id=${gallery.id}">${gallery.name}</a>
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
            <div class="content">
                <div class="left">
                    <div class="contact">
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
                    <div class="map">
                        <img src="image/map.jpg" width="700px" height="500px">
                    </div>
                </div>
                <div class="right">
                    <div class="share">
                        <div class="sharePage">Share this page</div>
                        <a class="social" href="#">
                            <div class="fb">
                                Share on Facebook
                            </div>
                        </a>
                        <a class="social" href="#">
                            <div class="twitter">
                                Share on Twitter
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="number">0  9  5  7  9  6</div>
            </div>
        </div>
    </body>
</html>
