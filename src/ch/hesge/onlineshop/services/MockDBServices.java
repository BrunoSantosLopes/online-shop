package ch.hesge.onlineshop.services;

import ch.hesge.onlineshop.models.Image;
import ch.hesge.onlineshop.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MockDBServices implements IDBServices {

    private List<Product> products = new ArrayList<>();
    private List<Product> productsCaddy = new ArrayList<>();

    public MockDBServices() {
        products.add(new Product(UUID.fromString("b5fd1df4-7bc9-11e9-8f9e-2a86e4085a59"),
                "My Product" + 1,
                10.2,
                new Image("product.jpg"),
                new ArrayList<Image>()
                {{
                    add(new Image("product.jpg"));
                }},
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(UUID.fromString("b5fd209c-7bc9-11e9-8f9e-2a86e4085a59"),
                "My Product" + 2,
                20.3,
                new Image("product2.png"),
                new ArrayList<Image>()
                {{
                    add(new Image("product2.png"));
                    add(new Image("product2.png"));
                }},
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(UUID.fromString("f74aebc4-7bc9-11e9-8f9e-2a86e4085a59"),
                "My Product" + 3,
                30.0,
                new Image("product3.jpg"),
                new ArrayList<Image>()
                {{
                    add(new Image("product3.jpg"));
                    add(new Image("product3.jpg"));
                    add(new Image("product3.jpg"));
                }},
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(UUID.fromString("f74aee4e-7bc9-11e9-8f9e-2a86e4085a59"),
                "My Product" + 4,
                40.0,
                new Image("product.jpg"),
                new ArrayList<Image>()
                {{
                    add(new Image("product.jpg"));
                }},
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(UUID.fromString("f74af466-7bc9-11e9-8f9e-2a86e4085a59"),
                "My Product" + 5,
                50.0,
                new Image("product2.png"),
                new ArrayList<Image>()
                {{
                    add(new Image("product2.png"));
                    add(new Image("product2.png"));
                }},
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(UUID.fromString("f74af6b4-7bc9-11e9-8f9e-2a86e4085a59"),
                "My Product" + 6,
                60.50,
                new Image("product3.jpg"),
                new ArrayList<Image>()
                {{
                    add(new Image("product3.jpg"));
                    add(new Image("product3.jpg"));
                }},
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(UUID.fromString("b5fd29a2-7bc9-11e9-8f9e-2a86e4085a59"),
                "My Product" + 7,
                70.90,
                new Image("product.jpg"),
                new ArrayList<Image>()
                 {{
                     add(new Image("product.jpg"));
                 }},
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(UUID.fromString("b5fd2ace-7bc9-11e9-8f9e-2a86e4085a59"),
                "My Product" + 8,
                80.0,
                new Image("product2.png"),
                new ArrayList<Image>()
                {{
                    add(new Image("product2.png"));
                    add(new Image("product2.png"));
                }},
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
        products.add(new Product(UUID.fromString("b5fd2ef2-7bc9-11e9-8f9e-2a86e4085a59"),
                "My Product" + 9,
                90.0,
                new Image("product3.jpg"),
                new ArrayList<Image>()
                {{
                    add(new Image("product3.jpg"));
                    add(new Image("product3.jpg"));
                    add(new Image("product3.jpg"));
                }},
                "Nulla facilisi. Sed malesuada lacus tellus, nec faucibus nunc rhoncus ut. Aenean vel diam vel lectus tincidunt pretium sit amet nec augue. Quisque eget diam at nisi eleifend pulvinar. Sed quis quam maximus, ornare magna ac, pharetra diam. Cras eu posuere eros, facilisis facilisis diam. Aenean blandit imperdiet magna nec tincidunt. Donec facilisis turpis nibh, in mollis orci posuere nec. Fusce et varius risus. Etiam vestibulum mi ullamcorper lacinia finibus. Proin varius urna scelerisque, tristique tellus id, consequat velit.\n" + "\n" + "Mauris vel neque felis. Fusce id lacus justo. Nullam nisl est, laoreet non ultrices auctor, egestas vel diam. Aenean vitae viverra erat. Quisque tristique nisl ut mollis eleifend. Cras sed sem nisl. Aliquam erat volutpat. Etiam posuere ligula at lorem placerat rhoncus. "
        ));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProduct(UUID uuid) {
        Product product = products.stream().filter(x -> x.getID().equals(uuid)).findFirst().get();
        return product;
    }

    @Override
    public List<Product> getProducts(int size) {
        return products.stream().limit(size).collect(Collectors.toList());
    }

}
