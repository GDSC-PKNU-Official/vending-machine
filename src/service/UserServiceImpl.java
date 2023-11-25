package service;

import domain.Product;
import domain.UserType;
import util.message.SystemMessage;

import static domain.Temperature.COLD;
import static domain.Temperature.HOT;

public class UserServiceImpl implements UserService {
    private final ProductService productService;
    private final SystemMessage systemMessage;
    private final UserType user;

    public UserServiceImpl(ProductService productService, SystemMessage systemMessage) {
        this.productService = productService;
        this.systemMessage = systemMessage;
        this.user = UserType.USER;
    }

    @Override
    public void selectTemperature(String input) {
        if (input.equals("1")) {
            systemMessage.printProductMenu(productService.getProductsByTemperature(COLD), COLD);
        } else if (input.equals("2")) {
            systemMessage.printProductMenu(productService.getProductsByTemperature(HOT), HOT);
        } else {
            System.out.println("올바른 값을 입력 하십시오.");
        }
    }

    @Override
    public Product selectProduct(String input) {
        return productService.getProductByProductId(Long.parseLong(input));
    }

    @Override
    public void selectPaymentMethod(String input, Product product) {
        if (input.equals("1")) {
            insertCash(product);
        } else if (input.equals("2")) {
            systemMessage.cardResult(product);
        }
    }

    @Override
    public void insertCash(Product product) {
        String input;
        int insertedCash = 0;
        while (insertedCash <= product.getCost()) {
            systemMessage.printCashMenu(insertedCash);
            input = systemMessage.inputMessage(user);
            if (input.equals("0")) {
                insertedCash = 0;
            }
            insertedCash += selectedCash(input);
        }
    }

    @Override
    public int selectedCash(String input) {
        if (input.equals("1")) {
            return 50000;
        } else if (input.equals("2")) {
            return 10000;
        } else if (input.equals("3")) {
            return 5000;
        } else if (input.equals("4")) {
            return 1000;
        } else if (input.equals("5")) {
            return 500;
        } else if (input.equals("6")) {
            return 100;
        } else {
            System.out.println("잘못된 입력값");
        }
        return 0;
    }
}
