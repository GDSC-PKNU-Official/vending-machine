package repository;

import domain.Product;

import java.util.List;

public interface ProductRepository {
    void add(Product product);

    void delete(Long productId);

    Product get(Long productId);

    List<Product> getColdProducts();

    List<Product> getHotProducts();
}
