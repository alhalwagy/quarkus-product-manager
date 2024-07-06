package org.fawry.service;

import java.util.List;
import org.fawry.excptions.CustomExceptions.NotAuthorizedException;
import org.fawry.model.Product;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(int id) throws NotAuthorizedException;

    void  addProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);

    Product getProductByName(String name);

}
