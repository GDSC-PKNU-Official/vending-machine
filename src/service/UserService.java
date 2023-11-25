package service;

import domain.Product;

public interface UserService {
    void selectTemperature(String input);

    Product selectProduct(String input);

    void selectPaymentMethod(String input, Product product);

    void insertCash(Product product);

    int selectedCash(String input);
}
