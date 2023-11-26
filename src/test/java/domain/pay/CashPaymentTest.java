package domain.pay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CashPaymentTest {

    @Test
    @DisplayName("거스름돈을 계산할 수 있다")
    void getChange() {
        //given
        final Cashes cashes = new Cashes(List.of(Cash.FIVE_HUNDRED_THOUSAND));
        final CashPayment cashPayment = new CashPayment(BigDecimal.valueOf(100_000L), cashes);

        //when
        final Cashes change = cashPayment.getChange();

        //then
        assertThat(change.value()).containsExactlyInAnyOrder(
                Cash.ONE_HUNDRED_THOUSAND,
                Cash.ONE_HUNDRED_THOUSAND,
                Cash.ONE_HUNDRED_THOUSAND,
                Cash.ONE_HUNDRED_THOUSAND);
    }

    @Test
    @DisplayName("거스름돈이 없는 경우는 빈 결과를 반환한다")
    void getChange_empty() {
        //given
        final Cashes cashes = new Cashes(List.of(Cash.FIVE_HUNDRED_THOUSAND));
        final CashPayment cashPayment = new CashPayment(BigDecimal.valueOf(500_000L), cashes);

        //when
        final Cashes change = cashPayment.getChange();

        //then
        assertThat(change.value()).isEmpty();
    }

    @Test
    @DisplayName("현재 총액이 계산할 금액보다 적은 경우는 예외가 발생한다")
    void getChange_fail() {
        //given
        final Cashes cashes = new Cashes(List.of(Cash.ONE_HUNDRED_THOUSAND));
        final CashPayment cashPayment = new CashPayment(BigDecimal.valueOf(500_000L), cashes);

        //when
        assertThatThrownBy(cashPayment::getChange)
                .isInstanceOf(IllegalStateException.class);
    }
}
