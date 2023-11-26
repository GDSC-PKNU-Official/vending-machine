package domain.pay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CashTest {

    @Test
    @DisplayName("현금끼리 더할 수 있다")
    void add() {
        //given
        final Cash cash = Cash.FIFTY_THOUSAND;

        //when
        final BigDecimal added = cash.add(Cash.FIFTY_THOUSAND);

        //then
        assertThat(added).isEqualTo(BigDecimal.valueOf(1_000_000));
    }
}
