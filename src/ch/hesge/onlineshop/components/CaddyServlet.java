package ch.hesge.onlineshop.components;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.CaddyServices;
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

@WebServlet("/components/caddy")
public class CaddyServlet extends HttpServlet {

    @Inject
    private CaddyServices caddyServices;
    @Inject
    private IDBServices dbServices;
    @Inject
    private ValidatorServices validatorServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sumProducts = caddyServices.getSumProducts(req);
        req.setAttribute("sumProducts", sumProducts);
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/components/caddy.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id-add") != null && validatorServices.isUUID(req.getParameter("id-add"))) {
            Product product = dbServices.getProduct(UUID.fromString(req.getParameter("id-add")));
            caddyServices.addProduct(product, req);
            resp.sendRedirect(req.getHeader("Referer"));
        }
        else if (req.getParameter("id-remove") != null && validatorServices.isUUID(req.getParameter("id-remove"))) {
            Product product = dbServices.getProduct(UUID.fromString(req.getParameter("id-remove")));
            caddyServices.removeProduct(product, req);
            resp.sendRedirect(req.getHeader("Referer"));
        }
        else if (req.getParameter("id-delete") != null && validatorServices.isUUID(req.getParameter("id-delete"))) {
            Product product = dbServices.getProduct(UUID.fromString(req.getParameter("id-delete")));
            caddyServices.deleteProduct(product, req);
            resp.sendRedirect(req.getHeader("Referer"));
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }


    }

}