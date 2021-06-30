
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
        <jsp:include page="header.jsp"/>

        <div class="content-wrap">
            <div class="left-area">
                <!--preIntro-->
                <div class="intro">
                    <div class="intro-image"><img src="${imagePath}${setting.titleImage}"></div>
                    <div class="intro-description">${setting.titleText}</div>
                </div>
                <div class="gallery-collection">
                    <c:forEach var="i" items="${top3}">
                        <div class="gallery-collection-item">
                            <div class="gallery-cover"><img src="${imagePath}${i.feturedPicture}"></div>
                            <div class="gallery-title"><a href="picture?id=${i.id}">View ${i.name}</a></div>
                            <div class="description">${i.description}</div>
                        </div>
                    </c:forEach>
                </div>
                <!--End show gallarys-->

                <!--Paging-->
                <div class="paging">

                    <c:if test="${maxPage<1}">
                        <h3>Not Found !!</h3>
                    </c:if>

                    <c:if test="${maxPage>1}">
                        <c:forEach begin="1" end="${maxPage}" var="i">
                            <a class="${i==pageIndex?"active":""}" href="home?page=${i}">${i}</a>
                        </c:forEach>
                    </c:if>
                    <div class="about-me">
                        <div class="large-title">${about.title}</div>
                        <div class="description">${about.description}</div>
                    </div>



                </div>
                <!--End paging-->

                <!--Intro about me-->
                <c:if test="${intro eq null}">
                    <h2>${errIntro}</h2>
                </c:if>
                <div class="about-me">
                    <div class="large-title">${messIntro}</div>

                    <div class="large-title">About Me</div>
                    <div class="description">${contact.about_me}</div>
                </div>
                <!--End Intro about me-->
            </div>

            <div class="right-area">
                <%@include file="right.jsp"%>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
