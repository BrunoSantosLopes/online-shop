package ch.hesge.onlineshop;

import ch.hesge.onlineshop.models.CreditCard;
import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.CaddyServices;
import ch.hesge.onlineshop.services.ValidatorServices;

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


@WebServlet("/payment")
public class PaymentServlet  extends HttpServlet {

    private CaddyServices caddyServices;
    private ValidatorServices validatorServices;

    @Inject
    public PaymentServlet (ValidatorServices validatorServices, CaddyServices caddyServices){
        this.validatorServices = validatorServices;
        this.caddyServices = caddyServices;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<Product, Integer> productsCaddy = caddyServices.getProducts(req);
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

        Boolean isValidForm= true;

        if (name == null || name.isEmpty() || name.trim().isEmpty()){
            isValidForm = false;
            req.setAttribute("nameMessage", "Le nom est requis");
        }
        if (!validatorServices.isValidEmail(email)){
            isValidForm = false;
            req.setAttribute("emailMessage", "L'email est invalide");
        }
        if (!validatorServices.isValidNumberCard(numberCard)){
            isValidForm = false;
            req.setAttribute("numberCardMessage", "La carte de crédit est invalide");
        }
        if (!validatorServices.isValidMonth(month)){
            isValidForm = false;
            req.setAttribute("monthMessage", "Le mois est invalide");
        }
        if (!validatorServices.isValidYear(year)){
            isValidForm = false;
            req.setAttribute("yearMessage", "L'année est invalide");
        }

        if (!isValidForm) {
            HashMap<Product, Integer> productsCaddy = caddyServices.getProducts(req);
            req.setAttribute("productsCaddy", productsCaddy);
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("numberCard", numberCard);
            req.setAttribute("month", month);
            req.setAttribute("year", year);
            resp.setContentType("text/html");
            req.getRequestDispatcher("/WEB-INF/payment.jsp").forward(req, resp);
        } else {
            CreditCard creditCard = new CreditCard(name, email, numberCard, Integer.parseInt(month), Integer.parseInt(year));
            caddyServices.clear(req);
            String message = "Merci pour votre commande !";
            resp.sendRedirect(req.getContextPath() +"/products?message="+ URLEncoder.encode(message, StandardCharsets.UTF_8.name()));
        }
    }
}