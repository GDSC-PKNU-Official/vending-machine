package domain.pay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CashesTest {

    @Test
    @DisplayName("주어진 금액보다 작으면 false를 리턴한다")
    void isGreaterOrEqualThan_false() {
        //given
        final Cashes cashes = new Cashes(Collections.emptyList());

        //when
        final boolean result = cashes.isGreaterOrEqualThan(BigDecimal.TEN);

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("주어진 금액보다 크면 true를 리턴한다")
    void isGreaterOrEqualThan_greater() {
        //given
        final Cashes cashes = new Cashes(List.of(Cash.FIVE_HUNDRED_THOUSAND));

        //when
        final boolean result = cashes.isGreaterOrEqualThan(BigDecimal.TEN);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("주어진 금액과 같으면 true를 리턴한다")
    void isGreaterOrEqualThan_equal() {
        //given
        final Cashes cashes = new Cashes(List.of(Cash.FIVE_HUNDRED_THOUSAND));

        //when
        final boolean result = cashes.isGreaterOrEqualThan(BigDecimal.TEN);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("현재 총액에서 주어진 금액을 뺀 값을 계산할 수 있다")
    void minus() {
        //given
        final Cashes cashes = new Cashes(List.of(Cash.FIVE_HUNDRED_THOUSAND));

        //when
        final BigDecimal result = cashes.minus(BigDecimal.valueOf(400_000L));

        //then
        assertThat(result).isEqualTo(BigDecimal.valueOf(100_000L));
    }
}
