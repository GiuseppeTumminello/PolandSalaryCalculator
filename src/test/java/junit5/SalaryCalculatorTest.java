package junit5;

import org.example.SalaryCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.math.BigDecimal;


class SalaryCalculatorTest {

    private SalaryCalculator salaryCalculator;

    @ParameterizedTest
    @CsvSource({"6000.00, 822.6000", "7000.00, 959.7000", "15891.68, 2178.7492"})
    void getZusTotal(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getZusTotal());
    }

    @ParameterizedTest
    @CsvSource({"6000.00, 465.96600", "7000.00, 543.62700", "15891.68, 1234.16377"})
    void getHealthNfzTotal(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getHealthNfzTotal());
    }

    @ParameterizedTest
    @CsvSource({"6000.00, 391.9913088", "7000.00, 457.3231936", "15891.68, 1786.9594387"})
    void getAdvancePaymentTotal(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getAdvancePaymentTotal());
    }

    @ParameterizedTest
    @CsvSource({"6000.00, 4319.4426912", "7000.00, 5039.3498064", "15891.68, 10691.8075913"})
    void getNet(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getNet());

    }

    @ParameterizedTest
    @CsvSource({"6000.00,585.60000", "7000.00, 683.2", "15891.68, 1551.027968"})
    void getZusPension(BigDecimal input, BigDecimal expected) {
        salaryCalculator = new SalaryCalculator(input);
        Assertions.assertEquals(expected, salaryCalculator.getNet());

    }

    @Test
    void getZusDisability() {
    }

    @Test
    void getZusSickness() {
    }

    @Test
    void getAnnualSum() {
    }


    @Test
    void getGross() {
    }

    @Test
    void getTaxRate() {
    }
}