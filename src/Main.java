import domain.PaymentMethod;
import domain.Product;
import domain.UserType;
import service.*;
import util.message.SystemMessage;

import static domain.Temperature.*;
import static domain.UserType.*;

public class Main {
    private static ProductService productService;
    private static SystemMessage systemMessage;
    private static UserService userService;
    private static AdminService adminService;

    public static void main(String[] args) {
        UserType user = USER;
        initialize();
        systemMessage.welcome();
        String input;
        input = systemMessage.inputMessage(user);
        if (input.equals("admin")) {
            user = ADMIN;

            return;
        }
        systemMessage.printTemperatureMenu();
        userService.selectTemperature(systemMessage.inputMessage(user));
        Product product = userService.selectProduct(systemMessage.inputMessage(user));

        systemMessage.printPaymentMethodMenu();

        PaymentMethod paymentMethod = userService.selectPaymentMethod(systemMessage.inputMessage(user), product);
        if (paymentMethod.equals(PaymentMethod.CASH)) {
            int insertedCash = userService.insertCash(product);
            systemMessage.cashResult(product, insertedCash);
        } else if (paymentMethod.equals(PaymentMethod.CARD)) {
            systemMessage.cardResult(product);
        } else {
            System.out.println("잘못된 입력값");
        }
    }

    public static void initialize() {
        productService = new ProductServiceImpl();
        systemMessage = new SystemMessage();
        userService = new UserServiceImpl(productService, systemMessage);
        adminService = new AdminServiceImpl(productService, systemMessage);

        initData();
    }

    public static void initData() {
        Product product1 = new Product(COLD, "스프라이트", 1500);
        productService.addProduct(product1);
        Product product2 = new Product(COLD, "코카콜라", 1500);
        productService.addProduct(product2);
        Product product3 = new Product(COLD, "솔의 눈", 1500);
        productService.addProduct(product3);
        Product product4 = new Product(HOT, "팥죽", 1500);
        productService.addProduct(product4);
    }
}