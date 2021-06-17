
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
                <c:if test="${error != null}">
                    <div class="left">
                        <span>${error}</span>
                    </div>
                </c:if>
                <c:if test="${error == null}">
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
                                <img class="mySlides" src="${imagePath}${i.name}" alt="Gallery slider images">
                            </c:forEach>
                        </div>
                        <table>
                            <tr>
                                <c:forEach items="${pictures}" var="i">
                                    <c:if test="${i.id <= 4}">
                                        <td>
                                            <div class="bgPicture">
                                                <img class="imageItem" src="${imagePath}${i.name}" alt="Gallery images" onclick="plusDivs(${i.id} - 1)">
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
                                                <img class="imageItem" src="${imagePath}${i.name}" alt="Gallery images" onclick="plusDivs(${i.id} - 1)">
                                            </div>
                                        </td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </table>
                    </div>
                </c:if>
                <jsp:include page="right.jsp" />
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
    <script src="js/gallery.js"></script>
</html>
