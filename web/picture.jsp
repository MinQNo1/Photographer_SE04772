
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/app.css" rel="stylesheet" type="text/css"/>
        <link href="css/picture.css" rel="stylesheet" type="text/css"/>
        <title>Gallery</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container">
            <div class="content">
                <div class="left">
                    <div class="titleGallery">
                        <c:forEach items="${galleries}" var="i">
                            <c:if test="${i.id == gId}">
                                ${i.name}
                            </c:if>
                        </c:forEach>
                    </div>
                    <div class="slide">
                        <c:forEach items="${pictures}" var="i">
                            <img class="mySlides" src="${imagePath}${i.name}">
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
                                            <img class="imageItem" src="${imagePath}${i.name}" width="150px" height="130px" >
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
                                            <img class="imageItem" src="${imagePath}${i.name}" width="150px" height="130px" >
                                        </div>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </table>
                </div>
                <jsp:include page="right.jsp" />
            </div>

        </div>
        <jsp:include page="footer.jsp" />
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
