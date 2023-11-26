package service;

import domain.Product;
import domain.Temperature;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    Product getProductByProductId(Long productId);

    void deleteByProductId(Long productId);

    List<Product> getProductsByTemperature(Temperature temperature);
}
