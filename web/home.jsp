
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
                                <img src="${imagePath}${setting.titleImage}">
                                <i class="imageCaption"></i><p>${setting.titleText}</p>
                            </div>
                            <table>
                                <tr>
                                    <c:forEach items="${galleries}" var="i">
                                        <td><a><img src="${imagePath}${i.feturedPicture}"><a></td>
                                    </c:forEach> 
                                </tr>
                                <tr>
                                    <c:forEach items="${galleries}" var="i">
                                        <td><h4><a class="viewGallery" href="picture?id=${i.id}">View ${i.name}</a></h4></td>
                                    </c:forEach> 
                                </tr>
                                <tr>
                                    <c:forEach items="${galleries}" var="i">
                                        <td><div class="description"><p>${i.description}</p></div></td>
                                    </c:forEach> 
                                </tr>
                            </table>
                        </div>
                        <c:if test="${maxPage<1}">
                            <h3>Not Found !!</h3>
                        </c:if>
                        <c:if test="${maxPage>1}">
                            <div class="pagesContainer">
                                <c:forEach begin="1" end="${maxPage}" var="i">
                                    <a class="pages ${i==pageIndex?"active":""}" href="home?page=${i}">${i}</a>
                                </c:forEach>
                            </div>
                        </c:if>
                        <div class="about">
                            <div class="about_me"><h3>About me</h3></div>
                            <div class="content">
                                <div class="aboutText">${contact.about_me}</div>
                            </div>
                        </div>
                    </div>
                    <jsp:include page="right.jsp" />
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
