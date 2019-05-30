package ch.hesge.onlineshop.components;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.IDBServices;
import ch.hesge.onlineshop.services.ValidatorServices;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/components/product")
public class ProductServlet extends HttpServlet {

    @EJB
    private IDBServices dbServices;
    private ValidatorServices validatorServices;

    @Inject
    public ProductServlet(ValidatorServices validatorServices){
        this.validatorServices = validatorServices ;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (validatorServices.isInt(id)){
            Product product = dbServices.getProduct(Integer.parseInt(id));
            req.setAttribute("product", product);
            resp.setContentType("text/html");
            req.getRequestDispatcher("/WEB-INF/components/product.jsp").include(req, resp);
        }
        else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}

