package ch.hesge.onlineshop;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.IDBServices;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @EJB
    private IDBServices dbServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = dbServices.getProducts();

        if (products != null && !products.isEmpty()){
            resp.setContentType("text/html");
            req.setAttribute("products", products);
            req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, resp);
        }
        else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}