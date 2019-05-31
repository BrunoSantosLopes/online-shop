package ch.hesge.onlineshop.services;

import ch.hesge.onlineshop.models.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;


@SessionScoped
@Named
public class CaddyServices implements Serializable {

    private Map<Product, Integer> caddy = new HashMap<>();

    public void addProduct(Product product) {
        if (caddy.containsKey(product)){
            caddy.put(product, caddy.get(product)+1 );
        }else{
            caddy.put(product,1);
        }
    }

    public Map<Product, Integer> getProducts(){
       return caddy;
    }

    public int getSumProducts(){
         List<Integer> values = new ArrayList<>(caddy.values());
        return values.stream().mapToInt(i->i).sum();
    }


    public void removeProduct(Product product) {
        if (caddy.containsKey(product) && caddy.get(product) > 1){
            caddy.put(product, caddy.get(product)-1 );
        }
    }

    public void deleteProduct(Product product) {
        caddy.remove(product);
    }

    public void clear() {
        caddy =  new HashMap<>();
    }
}
