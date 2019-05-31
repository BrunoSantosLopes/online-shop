package ch.hesge.onlineshop.listeners;

import ch.hesge.onlineshop.models.Product;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        setCaddy(httpSessionEvent);
    }

    private void setCaddy(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute("caddy", new HashMap<Product, Integer>());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //rien à faire
    }
}
