package service;

import repository.ProductRepository;
import repository.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = new ProductRepositoryImpl();
    }


}
