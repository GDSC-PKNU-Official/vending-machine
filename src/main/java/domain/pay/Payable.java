package domain.pay;

import java.math.BigDecimal;

public interface Payable {
    boolean proceedPayment();

    BigDecimal getTotalPrice();

    void addCash(Cash cash);
}
