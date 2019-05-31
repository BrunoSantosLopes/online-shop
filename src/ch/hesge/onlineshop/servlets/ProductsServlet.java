package ch.hesge.onlineshop.servlets;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.ProductsServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    private final ProductsServices productsServices;

    public ProductsServlet(ProductsServices productsServices) {
        this.productsServices = productsServices;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productsServices.getProducts();
        resp.setContentType("text/html");
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, resp);
    }
}