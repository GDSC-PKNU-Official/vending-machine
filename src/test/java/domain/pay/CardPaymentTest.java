package domain.pay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CardPaymentTest {

    @Test
    @DisplayName("10% 추가된 금액을 계산할 수 있다")
    void getTotalPrice() {
        //given
        final CardPayment cardPayment = new CardPayment(BigDecimal.valueOf(500000L));

        //when
        final BigDecimal totalPrice = cardPayment.getTotalPrice();

        //then
        assertThat(totalPrice).isEqualTo(BigDecimal.valueOf(550000L));
    }
}
