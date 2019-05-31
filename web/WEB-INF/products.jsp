<%--
  Created by IntelliJ IDEA.
  User: Bruno
  Date: 27.04.2019
  Time: 11:28
--%>
<%@ page import="ch.hesge.onlineshop.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/images/cat-logo.png">
    <title>OnlineShop - Produits</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/body.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/products.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/menu-bar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/caddy.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/product.css">
<body>
<jsp:include page="/menu-bar"/>
<div class="container">
    <%
        String message = request.getParameter("message");
        if (message != null && !message.isEmpty()) {
    %>
    <div class="banner">
        <h2 class="banner-text">
            <%= message %>
        </h2>
    </div>
    <% } %>
    <h1>OnlineShop - Produits</h1>
    <div class="container-products">
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            for (Product product : products) {
        %>
        <jsp:include page="/product/" flush="true">
            <jsp:param name="id" value="<%=product.getID()%>"/>
            <jsp:param name="full" value="false"/>
        </jsp:include>

        <%}%>
    </div>
</div>
</body>
</html>
