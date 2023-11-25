package service;

import domain.Product;
import domain.Temperature;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl() {
        this.productRepository = new ProductRepositoryImpl();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product getProductByProductId(Long productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public void deleteByProductId(Long productId) {
        productRepository.delete(productId);
    }

    @Override
    public List<Product> getProductsByTemperature(Temperature temperature) {
        List<Product> productList = productRepository.findAllProducts();
        List<Product> filteredProductList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getTemperture() == temperature) {
                filteredProductList.add(product);
            }
        }
        return filteredProductList;
    }
}
