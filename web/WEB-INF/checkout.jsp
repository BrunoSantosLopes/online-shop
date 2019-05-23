<%@ page import="java.util.HashMap" %>
<%@ page import="ch.hesge.onlineshop.models.Product" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Bruno
  Date: 27.04.2019
  Time: 11:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/images/cat-logo.png">
    <title>OnlineShop - Checkout</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/body.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/checkout.css">
</head>
<body>
    <div class="container">
        <table class="table">
            <%
                Double total = 0.0;
                HashMap<Product, Integer> productsCaddy= (HashMap<Product, Integer>) request.getAttribute("productsCaddy");
                for (Map.Entry<Product,Integer> rowProductsCaddy: productsCaddy.entrySet()) {
                    Double price = rowProductsCaddy.getKey().getPrice() * rowProductsCaddy.getValue();
                    total += price;

            %>
                <tr class="row">
                    <td>
                        <div class="cell">
                            <%=rowProductsCaddy.getKey().getName()%>
                        </div>
                    </td>
                    <td>
                        <div class="cell">
                            <%=rowProductsCaddy.getValue()%>
                            <div class="table-cell-container-button">
                                <form action="${pageContext.request.contextPath}/components/caddy" method="post">
                                    <input type="hidden" name="id-add" value="<%=rowProductsCaddy.getKey().getID()%>">
                                    <button class="table-cell-button" type="submit">+</button>
                                </form>
                                <form action="${pageContext.request.contextPath}/components/caddy" method="post">
                                    <input type="hidden" name="id-remove" value="<%=rowProductsCaddy.getKey().getID()%>">
                                    <button class="table-cell-button" type="submit">-</button>
                                </form>
                            </div>
                        </div>
                    </td>
                    <td>
                        <div class="cell">
                            <form action="${pageContext.request.contextPath}/components/caddy" method="post">
                                <input type="hidden" name="id-delete" value="<%=rowProductsCaddy.getKey().getID()%>">
                                <button class="table-cell-button" type="submit">
                                    <img class="image-trash" src="${pageContext.request.contextPath}/assets/images/trash.png">
                                </button>
                            </form>
                        </div>
                    </td>
                    <td>
                        <div class="cell">
                            CHF <%=String.format("%.2f",price)%>-
                        </div>
                    </td>
                </tr>
            <%}%>
        </table>
        <div class="container-total">
            <h2>Total</h2>
            <h2>CHF <%=String.format("%.2f",total)%>-</h2>
        </div>
        <div class="container-pay">
            <p><a class="back-link" href="${pageContext.request.contextPath}/products">Retour au shopping</a></p>
            <% if (productsCaddy.size() > 0) { %>
                <p><a class="pay-link" href="${pageContext.request.contextPath}/payment">Payer</a></p>
            <% } else {%>
                <p><a class="pay-link-disable">Pay</a></p>
            <% } %>

        </div>
    </div>
</body>
</html>
