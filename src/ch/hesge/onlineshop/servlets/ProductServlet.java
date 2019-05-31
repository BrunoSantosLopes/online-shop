package ch.hesge.onlineshop.servlets;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.ProductsServices;
import ch.hesge.onlineshop.services.DataValidator;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/*")
public class ProductServlet extends HttpServlet {

    private final ProductsServices productsServices;
    private final DataValidator dataValidator;

    @Inject
    public ProductServlet(DataValidator dataValidator, ProductsServices productsServices) {
        this.dataValidator = dataValidator;
        this.productsServices = productsServices;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String full = req.getParameter("full");

        if (!dataValidator.isInt(id) || full == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);

        } else if (Boolean.parseBoolean(full)) {
            Product product = productsServices.getProduct(Integer.parseInt(id));
            req.setAttribute("product", product);
            resp.setContentType("text/html");
            req.getRequestDispatcher("/WEB-INF/product-full.jsp").forward(req, resp);
        }
        else {
            Product product = productsServices.getProduct(Integer.parseInt(id));
            req.setAttribute("product", product);
            resp.setContentType("text/html");
            req.getRequestDispatcher("/WEB-INF/product.jsp").include(req, resp);
        }

    }
}

