package ch.hesge.onlineshop.listeners;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.ProductsServices;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ApplicationListener implements ServletContextListener {

    private List<Product> products = new ArrayList<>();
    private final ProductsServices productsServices;

    @Inject
    public ApplicationListener(ProductsServices productsServices) {
        this.productsServices = productsServices;
        setupProducts();
    }

    private void setDBData() {
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

    private void setupProducts() {
        products.add(new Product(
                "My Product" + 1,
                10.2,
                "product.jpg",
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 2,
                20.3,
                "product2.png",
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 3,
                30.0,
                "product3.jpg",
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 4,
                40.0,
                "product.jpg",
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 5,
                50.0,
                "product2.png",
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 6,
                60.50,
                "product3.jpg",
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 7,
                70.90,
                "product.jpg",
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 8,
                80.0,
                "product2.png",
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 9,
                90.0,
                "product3.jpg",
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
    }

}
