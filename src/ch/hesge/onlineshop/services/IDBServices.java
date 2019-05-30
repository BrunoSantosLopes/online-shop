package ch.hesge.onlineshop.services;

import ch.hesge.onlineshop.models.Product;

import java.util.List;

public interface IDBServices {
    List<Product> getProducts();
    List<Product> getProducts(int size);
    Product getProduct(int id);
    void persistProducts(List<Product> products) throws Exception;
}
