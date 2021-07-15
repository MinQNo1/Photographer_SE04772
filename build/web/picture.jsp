
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/app.css" rel="stylesheet" type="text/css"/>
        <link href="css/gallery.css" rel="stylesheet" type="text/css"/>
        <title>Gallery</title>
    </head>
    <body>
        <div class="wrapper">  
            <jsp:include page="header.jsp"/>
            <div class="content-wrap">
                <div class="left-area">
                    <div class="name">${gal.name}</div>
                    <div class="slides">
                        <h2>${message}</h2>
                        <c:forEach var="i" items="${imgs}">
                            <img class="gallery-big-image" src="${imagePath}${i.name}" >
                        </c:forEach>
                    </div>
                    <div class="gallery-list-container">
                        <c:forEach var="i" items="${imgs}" varStatus="loop" >
                            <div class="gallery-item" >
                                <img id="choiceImage" src="${imagePath}${i.name}" onclick="plusDivs(${i.id} - 1)">
                            </div>
                        </c:forEach>
                    </div>
                    <div class="paging">
                        <c:if test="${maxPage<1}">
                            <h3>Not Found !!</h3>
                        </c:if>
                        <c:if test="${maxPage>1}">
                            <c:forEach begin="1" end="${maxPage}" var="i">
                                <a class="${i==pageIndex?"active":""}" href="picture?txtPage=${i}&id=${id}">${i}</a>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <div class="right-area">
                    <jsp:include page="right.jsp"/>
                </div>
            </div>
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
    <script src="js/gallery.js"></script>
</html>
