package ch.hesge.onlineshop.components;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.IDBServices;
import ch.hesge.onlineshop.services.ValidatorServices;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/components/product")
public class ProductServlet extends HttpServlet {

    @Inject
    private IDBServices dbServices;
    @Inject
    private ValidatorServices validatorServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (validatorServices.isUUID(id)){
            Product product = dbServices.getProduct(UUID.fromString(id));
            req.setAttribute("product", product);
            resp.setContentType("text/html");
            req.getRequestDispatcher("/WEB-INF/components/product.jsp").include(req, resp);
        }
        else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}

