
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/app.css" rel="stylesheet" type="text/css"/>
        <title>Gallery</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp" />
            <div class="content">
                <div class="left">
                    <div class="titleGallery">
                        <c:forEach items="${galleries}" var="i">
                            <c:if test="${i.id == gId}">
                                ${i.name}
                            </c:if>
                        </c:forEach>
                    </div>
                    <div class="gallery">
                        <c:forEach items="${pictures}" var="i">
                            <img class="mySlides" src="image/${i.name}" width="700px" height="500px" >
                        </c:forEach>
                        <div class="control">
                            <button class="btnLeft" onclick="plusDivs(-1)"><</button>
                            <button class="btnRight" onclick="plusDivs(1)">></button>
                        </div>
                    </div>
                    <table>
                        <tr>
                            <c:forEach items="${pictures}" var="i">
                                <c:if test="${i.id <= 4}">
                                    <td>
                                        <div class="bgPicture">
                                            <img class="imageItem" src="image/${i.name}" width="150px" height="130px" >
                                        </div>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                        <tr>
                            <c:forEach items="${pictures}" var="i">
                                <c:if test="${i.id > 4}">
                                    <td>
                                        <div class="bgPicture">
                                            <img class="imageItem" src="image/${i.name}" width="150px" height="130px" >
                                        </div>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </table>
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
    <script>
        var slideIndex = 1;
        showDivs(slideIndex);

        function plusDivs(n) {
            showDivs(slideIndex += n);
        }

        function showDivs(n) {
            var i;
            var x = document.getElementsByClassName("mySlides");
            if (n > x.length) {
                slideIndex = 1;
            }
            if (n < 1) {
                slideIndex = x.length;
            }
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            x[slideIndex - 1].style.display = "block";
        }
    </script>
</html>
