package ch.hesge.onlineshop.servlets;

import ch.hesge.onlineshop.models.FormPayment;
import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.DataValidator;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

    private final DataValidator dataValidator;

    @Inject
    public PaymentServlet(DataValidator dataValidator) {
        this.dataValidator = dataValidator;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Product, Integer> productsCaddy = (Map<Product, Integer>) req.getSession().getAttribute("caddy");
        req.setAttribute("productsCaddy", productsCaddy);
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/payment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FormPayment formPayment = setupFormPayment(req);
        if (!dataValidator.isValidFormPayment(formPayment)) {
            setupErrorMessage(req, formPayment);
            setupAttribute(req, formPayment);
            Map<Product, Integer> productsCaddy = (Map<Product, Integer>) req.getSession().getAttribute("caddy");
            req.setAttribute("productsCaddy", productsCaddy);
            resp.setContentType("text/html");
            req.getRequestDispatcher("/WEB-INF/payment.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("caddy", new HashMap<>());
            String message = "Merci pour votre commande !";
            resp.sendRedirect(req.getContextPath() + "/products?message=" + URLEncoder.encode(message, StandardCharsets.UTF_8.name()));
        }
    }

    private FormPayment setupFormPayment(HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String numberCard = req.getParameter("numberCard");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        return new FormPayment(name, email, numberCard, month, year);
    }

    private void setupErrorMessage(HttpServletRequest req, FormPayment formPayment) {
        if (!formPayment.getValidEmail()) {
            req.setAttribute("emailMessage", "L'email est invalide");
        }
        if (!formPayment.getValidMonth()) {
            req.setAttribute("monthMessage", "Le mois est invalide");
        }
        if (!formPayment.getValidName()) {
            req.setAttribute("nameMessage", "Le nom est requis");
        }
        if (!formPayment.getValidNumberCard()) {
            req.setAttribute("numberCardMessage", "La carte de crédit est invalide");
        }
        if (!formPayment.getValidYear()) {
            req.setAttribute("yearMessage", "L'année est invalide");
        }
    }

    private void setupAttribute(HttpServletRequest req, FormPayment formPayment) {
        req.setAttribute("name", formPayment.getName());
        req.setAttribute("email", formPayment.getEmail());
        req.setAttribute("numberCard", formPayment.getNumberCard());
        req.setAttribute("month", formPayment.getMonth());
        req.setAttribute("year", formPayment.getYear());
    }
}