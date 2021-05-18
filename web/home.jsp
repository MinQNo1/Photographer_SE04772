
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Homepage</title>
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
            <div class="content">
                <div class="left">
                    <div class="gallery">
                        <div class="titleImg">
                            <img src="image/i4.jpg">
                            <i><p>Lorem ipsum dolor sit amet</p></i>
                        </div>
                        <table>
                            <tr>
                                <c:forEach items="${galleries}" var="i">
                                    <td><img src="image/${i.feturedPicture}"></td>
                                </c:forEach> 
                            </tr>
                            <tr>
                                <c:forEach items="${galleries}" var="i">
                                    <td><a class="viewGallery" href="picture?id=${i.id}">View ${i.name}</a></td>
                                </c:forEach> 
                            </tr>
                            <tr>
                                <c:forEach items="${galleries}" var="i">
                                    <td><div class="description">${i.description}</div></td>
                                </c:forEach> 
                            </tr>
                        </table>
                    </div>
                    <div class="about">
                        <div class="about_me">About me</div>
                        <div class="aboutText">${contact.about_me}</div>
                    </div>
                </div>
                <div class="right">
                    <div class="share">
                        <div class="sharePage">Share this page</div>
                        <div class="fb">
                            <a class="text-white" href="#">Share on Facebook</a>
                        </div>
                        <div class="twitter">
                            <a class="text-white" href="#">Share on Twitter</a>
                        </div>
                        </a>
                        <div class="google">
                            <a class="text-white" href="#">Share on Google+</a>
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
