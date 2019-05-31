package ch.hesge.onlineshop.listeners;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.DataServices;
import ch.hesge.onlineshop.services.ProductsServices;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ApplicationListener implements ServletContextListener {

    private final ProductsServices productsServices;
    private final DataServices dataServices;

    @Inject
    public ApplicationListener(DataServices dataServices, ProductsServices productsServices) {
        this.dataServices = dataServices;
        this.productsServices = productsServices;
    }

    private void setDBData() {
        List<Product> products = dataServices.getProducts();
        productsServices.persistProducts(products);
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        setDBData();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //rien à faire
    }
}
