import domain.Product;
import domain.Temperature;
import repository.ProductRepository;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;

public class Main {
    private static ProductService productService;

    public static void main(String[] args) {
        initialize();

        System.out.println("Hello 자판기!");
        
    }

    public static void initialize() {
        productService = new ProductServiceImpl();

        initData();
    }

    public static void initData() {
        Product product1 = new Product(Temperature.COLD, "스프라이트", 1500);
        productService.addProduct(product1);
        Product product2 = new Product(Temperature.COLD, "코카콜라", 1500);
        productService.addProduct(product2);
        Product product3 = new Product(Temperature.COLD, "솔의 눈", 1500);
        productService.addProduct(product3);
    }
}