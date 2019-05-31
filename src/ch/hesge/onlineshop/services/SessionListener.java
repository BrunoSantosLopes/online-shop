package ch.hesge.onlineshop.services;

import ch.hesge.onlineshop.models.Product;

import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.List;

@WebListener
public class SessionListener implements HttpSessionListener {


    private String SESSION_CADDY = "SESSION_CADDY";

    private DataServices dataServices;
    private IDBServices dbServices;

    @Inject
    public SessionListener(DataServices dataServices, IDBServices dbServices){
        this.dataServices = dataServices;
        this.dbServices = dbServices;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        setCaddy(httpSessionEvent);
        setDBData();
    }

    private void setDBData() {
        try {
            List<Product> products = dataServices.getProducts();
            dbServices.persistProducts(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCaddy(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(SESSION_CADDY, new HashMap<Product, Integer>());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
            //rien à faire
    }
}
