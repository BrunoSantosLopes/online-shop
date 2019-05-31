<%--
  Created by IntelliJ IDEA.
  User: Bruno
  Date: 27.04.2019
  Time: 11:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/images/cat-logo.png">
    <title>OnlineShop - Détails produit</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/body.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/products-details.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/menu-bar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/components/caddy.css">
</head>
<body>
    <jsp:include page="/components/menu-bar" />
   <div class="container">

        <div class="container-labels-product">
            <h1 class="title">${product.getName()}</h1>
            <p>
                ${product.getDescriptionHTML()}
            </p>
            <div class="price-product">
                <form action="${pageContext.request.contextPath}/components/caddy" method="post">
                    <input type="hidden" name="id-add" value="${product.getID()}">
                    <button class="price-button-product" type="submit">
                        <p class="price-text-product">
                            CHF ${String.format("%.2f",product.getPrice())}-
                        </p>
                        <img class="price-image-caddy-product" src="${pageContext.request.contextPath}/assets/images/caddie.png" alt="Checkout">
                    </button>
                </form>
            </div>
        </div>
        <div class="container-images-product">
            <img class="image-product" src="${pageContext.request.contextPath}/assets/images/${product.getImage().getUrlImage()}" alt="${product.getName()}">
        </div>
   </div>

</body>
</html>
