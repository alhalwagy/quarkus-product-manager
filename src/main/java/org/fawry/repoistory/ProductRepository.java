package org.fawry.repoistory;

import java.util.List;
import org.fawry.model.Product;

public interface ProductRepository {

    Product findProductById(int id);

    List<Product> findAll();

    void add(Product product);

    Product update(int id, Product product);

    int getProductListSize();

    void deleteProduct(int id);

    Product findProductByName(String name);

}
