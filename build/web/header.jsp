<%-- 
    Document   : header.jsp
    Created on : May 18, 2021, 5:37:13 PM
    Author     : QuyenNV
--%>

<div class="header">
    <div class="link">
        <a href="home">My front page</a>
        <c:forEach items="${galleries}" var="gallery">
            <a class="${gallery.id == gId?"fontBold":""}" href="picture?id=${gallery.id}">${gallery.name}</a>
        </c:forEach>
        <a href="contact">Contact</a>
    </div>
    <div class="title-wrapper">
        <div class="title-wrapper-inner">
            <a class="logo " href="http://us-123photo.simplesite.com/">
            </a>
            <div class="title ">
                <a class="title  title-link" href="http://us-123photo.simplesite.com/">
                    PHOTOGRAPHER
                </a> 
            </div>
            <div class="subtitle">
                Welcome to this website
            </div>
        </div>
    </div>
</div>
