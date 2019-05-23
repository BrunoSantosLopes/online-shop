package ch.hesge.onlineshop.services;

import ch.hesge.onlineshop.models.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class CaddyServices {

    private String SESSION_CADDY = "SESSION_CADDY";

    public void addProduct(Product product, HttpServletRequest req) {
        setupSessionCaddy(req);
        HashMap<Product, Integer> products = (HashMap<Product, Integer>)req.getSession().getServletContext().getAttribute(SESSION_CADDY);
        if (products.containsKey(product)){
            products.put(product, products.get(product)+1 );
        }else{
            products.put(product,1);
        }
        req.getSession().getServletContext().setAttribute(SESSION_CADDY,products);
    }

    public HashMap<Product, Integer> getProducts(HttpServletRequest req){
        setupSessionCaddy(req);
        HashMap<Product, Integer> products = (HashMap<Product, Integer>)req.getSession().getServletContext().getAttribute(SESSION_CADDY);
        return products;
    }

    public int getSumProducts(HttpServletRequest req){
        setupSessionCaddy(req);
        HashMap<Product, Integer> products = (HashMap<Product, Integer>)req.getSession().getServletContext().getAttribute(SESSION_CADDY);
        List<Integer> values = new ArrayList<>(products.values());
        return values.stream().mapToInt(i->i).sum();

    }

    private void setupSessionCaddy(HttpServletRequest req){
        if (req.getSession().getServletContext().getAttribute(SESSION_CADDY) == null){
            req.getSession().getServletContext().setAttribute(SESSION_CADDY, new HashMap<Product, Integer>());
        }
    }

    public void removeProduct(Product product, HttpServletRequest req) {
        setupSessionCaddy(req);
        HashMap<Product, Integer> products = (HashMap<Product, Integer>)req.getSession().getServletContext().getAttribute(SESSION_CADDY);

        if (products.containsKey(product) && products.get(product) > 1){
            products.put(product, products.get(product)-1 );
        }
        req.getSession().getServletContext().setAttribute(SESSION_CADDY,products);
    }

    public void deleteProduct(Product product, HttpServletRequest req) {
        setupSessionCaddy(req);
        HashMap<Product, Integer> products = (HashMap<Product, Integer>)req.getSession().getServletContext().getAttribute(SESSION_CADDY);
        products.remove(product);
        req.getSession().getServletContext().setAttribute(SESSION_CADDY,products);
    }

    public void clear(HttpServletRequest req) {
        req.getSession().getServletContext().setAttribute(SESSION_CADDY, new HashMap<Product, Integer>());
    }
}
