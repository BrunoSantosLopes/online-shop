<%--
  Created by IntelliJ IDEA.
  User: bruno.santoslo
  Date: 22.05.2019
  Time: 16:03
  Original page : https://marvelapp.com/404
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>OnlineShop - 404</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/images/cat-logo.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/body.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/errors/404.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/menu-bar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/caddy.css">
</head>
<body>
    <jsp:include page="/menu-bar"/>
    <div class="container">
        <img class="bad-luck-image" src="${pageContext.request.contextPath}/assets/images/bad-luck.gif">
        <h1>Oh non, pas de chance !</h1>
        <h3>La page que vous chercher n'a peut-être jamais été créer ou a été supprimer</h3>
        <p><a class="back-link" href="${pageContext.request.contextPath}/products">Retour au shopping</a></p>
    </div>
</body>
</html>
