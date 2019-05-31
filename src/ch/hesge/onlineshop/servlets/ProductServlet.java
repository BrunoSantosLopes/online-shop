package ch.hesge.onlineshop.servlets;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.ProductsServices;
import ch.hesge.onlineshop.services.ValidatorServices;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlets/product")
public class ProductServlet extends HttpServlet {

    private final ProductsServices productsServices;
    private final ValidatorServices validatorServices;

    @Inject
    public ProductServlet(ProductsServices productsServices, ValidatorServices validatorServices) {
        this.productsServices = productsServices;
        this.validatorServices = validatorServices;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (validatorServices.isInt(id)) {
            Product product = productsServices.getProduct(Integer.parseInt(id));
            req.setAttribute("product", product);
            resp.setContentType("text/html");
            req.getRequestDispatcher("/WEB-INF/servlets/product.jsp").include(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
