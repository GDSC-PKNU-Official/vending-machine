package repository;

import domain.Product;

import java.util.List;

public interface ProductRepository {
    void add(Product product);

    void delete(Long productId);

    Product findByProductId(Long productId);

    List<Product> findAllProducts();
}
