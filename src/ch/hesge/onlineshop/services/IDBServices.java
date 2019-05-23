package ch.hesge.onlineshop.services;

import ch.hesge.onlineshop.models.Product;

import java.util.List;
import java.util.UUID;

public interface IDBServices {
    List<Product> getProducts();

    Product getProduct(UUID uuid);

    List<Product> getProducts(int size);
}
