package repository;

import domain.Product;
import domain.Temperature;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {
    private Map<Long, Product> products = new HashMap<>();
    private Long productId = 1L;

    @Override
    public void add(Product product) {
        product.setProductId(productId);
        products.put(productId++, product);
    }

    @Override
    public void delete(Long productId) {
        products.remove(productId);
    }

    @Override
    public Product findByProductId(Long productId) {
        return products.get(productId);
    }

    @Override
    public List<Product> findAllProducts() {
        return new ArrayList<>(products.values());
    }
}
