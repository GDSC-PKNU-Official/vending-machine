package service;

import domain.PaymentMethod;
import domain.Product;

public interface UserService {
    void selectTemperature(String input);

    Product selectProduct(String input);

    PaymentMethod selectPaymentMethod(String input, Product product);

    int insertCash(Product product);

    int selectedCash(String input);
}
