package ch.hesge.onlineshop;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.DataServices;
import ch.hesge.onlineshop.services.IDBServices;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/setup")
public class SetupServlet extends HttpServlet {

    @EJB
    private IDBServices dbServices;
    private DataServices dataServices;

    @Inject
    public SetupServlet(DataServices dataServices){
        this.dataServices = dataServices;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (dbServices.getProducts(1).size() == 0){
            List<Product> products = dataServices.getProducts();
            try {
                dbServices.persistProducts(products);
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        resp.sendRedirect(req.getContextPath());
    }
}
