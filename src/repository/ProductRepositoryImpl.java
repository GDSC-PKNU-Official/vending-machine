package repository;

import domain.Product;

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
    public Product get(Long productId) {
        return products.get(productId);
    }

    @Override
    public List<Product> getColdProducts() {
        List<Product> coldProducts = new ArrayList<>();
        Iterator<>
        return null;
    }

    @Override
    public List<Product> getHotProducts() {
        return null;
    }
}
