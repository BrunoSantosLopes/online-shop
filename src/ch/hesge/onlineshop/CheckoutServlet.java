package ch.hesge.onlineshop;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.CaddyServices;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/checkout")
public class CheckoutServlet  extends HttpServlet {

    private CaddyServices caddyServices;

    @Inject
    public CheckoutServlet (CaddyServices caddyServices){
        this.caddyServices = caddyServices;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<Product, Integer> productsCaddy = caddyServices.getProducts(req);
        req.setAttribute("productsCaddy", productsCaddy);
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(req, resp);
    }
}