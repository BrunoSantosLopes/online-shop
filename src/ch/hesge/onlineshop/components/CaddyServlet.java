package ch.hesge.onlineshop.components;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.CaddyServices;
import ch.hesge.onlineshop.services.IDBServices;
import ch.hesge.onlineshop.services.ValidatorServices;

import javax.ejb.EJB;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/components/caddy")
public class CaddyServlet extends HttpServlet {

    @EJB
    private IDBServices dbServices;
    private CaddyServices caddyServices;
    private ValidatorServices validatorServices;

    @Inject
    public CaddyServlet (CaddyServices caddyServices, ValidatorServices validatorServices ){
        this.caddyServices = caddyServices;
        this.validatorServices = validatorServices;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/components/caddy.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id-add") != null && validatorServices.isInt(req.getParameter("id-add"))) {
            Product product = dbServices.getProduct(Integer.parseInt(req.getParameter("id-add")));
            caddyServices.addProduct(product);
            resp.sendRedirect(req.getHeader("Referer"));
        }
        else if (req.getParameter("id-remove") != null && validatorServices.isInt(req.getParameter("id-remove"))) {
            Product product = dbServices.getProduct(Integer.parseInt(req.getParameter("id-remove")));
            caddyServices.removeProduct(product);
            resp.sendRedirect(req.getHeader("Referer"));
        }
        else if (req.getParameter("id-delete") != null && validatorServices.isInt(req.getParameter("id-delete"))) {
            Product product = dbServices.getProduct(Integer.parseInt(req.getParameter("id-delete")));
            caddyServices.deleteProduct(product);
            resp.sendRedirect(req.getHeader("Referer"));
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }


    }

}