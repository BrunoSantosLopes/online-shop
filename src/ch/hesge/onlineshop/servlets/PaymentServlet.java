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

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String numberCard = req.getParameter("numberCard");
        String month = req.getParameter("month");
        String year = req.getParameter("year");

        FormPayment formPayment = new FormPayment(name, email, numberCard, month, year);

        if (!isValidFormPayment(formPayment, req)) {
            Map<Product, Integer> productsCaddy = (Map<Product, Integer>) req.getSession().getAttribute("caddy");
            req.setAttribute("productsCaddy", productsCaddy);
            req.setAttribute("name", formPayment.getName());
            req.setAttribute("email", formPayment.getEmail());
            req.setAttribute("numberCard", formPayment.getNumberCard());
            req.setAttribute("month", formPayment.getMonth());
            req.setAttribute("year", formPayment.getYear());
            resp.setContentType("text/html");
            req.getRequestDispatcher("/WEB-INF/payment.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("caddy", new HashMap<>());
            String message = "Merci pour votre commande !";
            resp.sendRedirect(req.getContextPath() + "/products?message=" + URLEncoder.encode(message, StandardCharsets.UTF_8.name()));
        }
    }

    public Boolean isValidFormPayment(FormPayment formPayment, HttpServletRequest req){
        Boolean isValid = true;

        if (formPayment.getName() == null || formPayment.getName().isEmpty() || formPayment.getName().trim().isEmpty()) {
            isValid = false;
            req.setAttribute("nameMessage", "Le nom est requis");
        }
        if (!dataValidator.isValidEmail(formPayment.getEmail())) {
            isValid = false;
            req.setAttribute("emailMessage", "L'email est invalide");
        }
        if (!dataValidator.isValidNumberCard(formPayment.getNumberCard())) {
            isValid = false;
            req.setAttribute("numberCardMessage", "La carte de crédit est invalide");
        }
        if (!dataValidator.isValidMonth(formPayment.getMonth())) {
            isValid = false;
            req.setAttribute("monthMessage", "Le mois est invalide");
        }
        if (!dataValidator.isValidYear(formPayment.getYear())) {
            isValid = false;
            req.setAttribute("yearMessage", "L'année est invalide");
        }

        return isValid;
    }

}