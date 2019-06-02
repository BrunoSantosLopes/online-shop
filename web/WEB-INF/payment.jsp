<%@ page import="ch.hesge.onlineshop.models.Product" %>
<%@ page import="java.util.Map" %>
<%--
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
    <title>OnlineShop - Paiement</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/body.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/payment.css">

</head>
<body>
<div class="container">
    <div class="container-form">
        <form class="form" action="${pageContext.request.contextPath}/payment" method="post">
            <div class="caddie">
                <table class="table">
                    <%
                        double total = 0.0;
                        Map<Product, Integer> productsCaddy = (Map<Product, Integer>) request.getAttribute("productsCaddy");
                        for (Map.Entry<Product, Integer> rowProductsCaddy : productsCaddy.entrySet()) {
                            double price = rowProductsCaddy.getKey().getPrice() * rowProductsCaddy.getValue();
                            total += price;
                    %>
                    <tr class="row">
                        <td>
                            <div class="cell"><%=rowProductsCaddy.getKey().getName()%>
                            </div>
                        </td>
                        <td>
                            <div class="cell"><%=rowProductsCaddy.getValue()%>
                            </div>
                        </td>
                        <td>
                            <div class="cell">CHF <%=String.format("%.2f", price)%>
                            </div>
                        </td>
                    </tr>

                    <%}%>
                </table>
                <div class="container-total">
                    <h3>Total</h3>
                    <h3>CHF <%=String.format("%.2f", total)%>-</h3>
                </div>

            </div>
            <div class="container-input">
                <div class="field">
                    <label>Nom : </label>
                    <div class="input">
                        <input name="name" type="text" placeholder="Nom" required autofocus autocomplete="off"
                               value="${name}"/>
                        <p class="red">${nameMessage}</p>
                    </div>
                </div>

                <div class="field">
                    <label>Email :</label>
                    <div class="input">
                        <input name="email" type="email" placeholder="Email" required autocomplete="off"
                               value="${email}"/>
                        <p class="red">${emailMessage}</p>
                    </div>
                </div>

                <div class="field">
                    <label>Carte de crédit :</label>
                    <div class="input">
                        <input name="numberCard" type="text" placeholder="Carte de crédit" minlength="16" maxlength="16"
                               required autocomplete="off" value="${numberCard}"/>
                        <p class="red">${numberCardMessage}</p>
                    </div>
                </div>

                <div class="field">
                    <label>Mois/Année validité :</label>
                    <div class="field-month-year">
                        <div class="input">
                            <input name="month" type="number" placeholder="Month" min="1" max="12" required
                                   autocomplete="off" value="${month}"/>
                            <p class="red">${monthMessage}</p>
                        </div>
                        <div class="input">
                            <input name="year" type="number" placeholder="Year" min="19" max="99" required
                                   autocomplete="off" value="${year}"/>
                            <p class="red">${yearMessage}</p>
                        </div>
                    </div>
                </div>

                <div class="container-order">
                    <% if (productsCaddy.size() > 0) { %>
                    <button class="pay-link" type="submit">Commander</button>
                    <% } else {%>
                    <input type="hidden" required>
                    <p class="pay-link-disable">Commander</p>
                    <% } %>
                </div>
            </div>

        </form>
    </div>
    <div class="container-back">
        <p><a class="back-link" href="${pageContext.request.contextPath}/products">Retour au shopping</a></p>
    </div>
</div>
</body>
</html>
