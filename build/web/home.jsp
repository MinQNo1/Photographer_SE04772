
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/app.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>Homepage</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container-fluid content-wrapper">
            <div class="container">
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
                    <jsp:include page="right.jsp" />
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
