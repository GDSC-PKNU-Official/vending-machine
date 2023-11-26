package domain.pay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        final Cashes cashes = new Cashes(List.of(Cash.FIFTY_THOUSAND));

        //when
        final boolean result = cashes.isGreaterOrEqualThan(BigDecimal.TEN);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("주어진 금액과 같으면 true를 리턴한다")
    void isGreaterOrEqualThan_equal() {
        //given
        final Cashes cashes = new Cashes(List.of(Cash.FIFTY_THOUSAND));

        //when
        final boolean result = cashes.isGreaterOrEqualThan(BigDecimal.TEN);

        //then
        assertThat(result).isTrue();
    }
}
