<%--
  Created by IntelliJ IDEA.
  User: Bruno
  Date: 27.04.2019
  Time: 11:27
--%>
<%@ page import="ch.hesge.onlineshop.models.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/images/cat-logo.png">
        <title>OnlineShop - Acceuil</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/body.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/home.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/menu-bar.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/caddy.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/product.css">
    </head>
<body>
    <div class="top-bar">
        <jsp:include page="/components/caddy" />
    </div>
    <div class="home" style="background-image: url('${pageContext.request.contextPath}/assets/images/home.jpg')">
        <div class="home-container" >
            <a href="${pageContext.request.contextPath}/products">
                <div>
                    <h1 class="home-title">Bienvenu à OnlineShop</h1>
                </div>
                <div class="home-container-description">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vel consequat massa. Quisque sed consectetur odio. Nulla at quam faucibus, dictum neque a, mollis ante. Aliquam et diam vel odio commodo faucibus quis in augue. Integer ut maximus metus. Nam varius vehicula tincidunt. In volutpat nibh quis risus pulvinar finibus. Morbi massa felis, pellentesque ac neque hendrerit, fringilla volutpat mi. Etiam sed magna non libero tincidunt tempor ut quis odio. Praesent dignissim odio sapien. Nulla facilisi.
                    </p>
                    <p>
                        Cras placerat euismod nunc. Sed sodales elementum massa vel mollis. Praesent tempor nunc ac magna mattis, sed fringilla magna placerat. Fusce bibendum fringilla nisi, non hendrerit velit dignissim ut. Etiam ullamcorper vestibulum ultricies. Suspendisse finibus elit a semper gravida. Quisque eget condimentum lacus. Phasellus urna libero, finibus sed volutpat sed, pellentesque eu metus. Vivamus placerat erat in lacus finibus, id euismod nibh vehicula. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam a mauris pellentesque, commodo felis vel, lobortis nisi.
                    </p>
                </div>
            </a>
        </div>
        <div class="container-products">
            <%
                List<Product> products= (ArrayList<Product>) request.getAttribute("products");
                for (Product product: products) {
            %>
                 <jsp:include page="/components/product"  flush="true">
                    <jsp:param name="id" value="<%=product.getID().toString()%>"/>
                </jsp:include>

            <%}%>
        </div>
    </div>
</body>
</html>


