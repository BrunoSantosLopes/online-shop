package ch.hesge.onlineshop.services;

import ch.hesge.onlineshop.models.Image;
import ch.hesge.onlineshop.models.Product;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DataServices {
    private List<Product> products = new ArrayList<>();

    public DataServices() {
        products.add(new Product(
                "My Product" + 1,
                10.2,
                new Image("product.jpg"),
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 2,
                20.3,
                new Image("product2.png"),

                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 3,
                30.0,
                new Image("product3.jpg"),

                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 4,
                40.0,
                new Image("product.jpg"),

                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 5,
                50.0,
                new Image("product2.png"),
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 6,
                60.50,
                new Image("product3.jpg"),
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 7,
                70.90,
                new Image("product.jpg"),
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 8,
                80.0,
                new Image("product2.png"),
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(
                "My Product" + 9,
                90.0,
                new Image("product3.jpg"),
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
    }

    public List<Product> getProducts() {
        return products;
    }
}
