package pl.dstelmaszynski.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class UsageCalculatorTest {

    @Test
    void testGasCost() {
        //given
        List<BigDecimal> gasPrice = List.of(BigDecimal.valueOf(6));
        List<BigDecimal> gasConsume = List.of(BigDecimal.valueOf(7));
        BigDecimal expected = BigDecimal.valueOf(42);

        //when
        UsageCalculator usageCalculator = new UsageCalculator();
        BigDecimal result = usageCalculator.gasCost(gasPrice, gasConsume);

        //then
        Assertions.assertEquals(expected, result);

    }

}