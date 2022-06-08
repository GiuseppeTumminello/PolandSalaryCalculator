package junit5.EnumTest;

import org.example.enumApproch.SalaryCalculatorEnum;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


class TestSalaryCalculatorEnum {


    @ParameterizedTest
    @CsvSource({"6000, 822.60", "7000, 959.70", "15891.68, 2178.75"})
    void getZusTotal(BigDecimal input, BigDecimal expected) {
        //Using AssertJ
        assertThat(SalaryCalculatorEnum.TOTAL_ZUS.getOperator().apply(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 465.97", "7000, 543.63", "15891.68, 1234.16"})
    void getHealthNfzTotal(BigDecimal input, BigDecimal expected) {
        assertThat(SalaryCalculatorEnum.HEALTH.getOperator().apply(input)).isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource({"6000, 391.99", "7000, 457.32", "15891.68, 1786.96"})
    void getAdvancePaymentTotal(BigDecimal input, BigDecimal expected) {
        assertThat(SalaryCalculatorEnum.TAX.getOperator().apply(input)).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource({"6000.,585.60", "7000, 683.20", "15891.68, 1551.03"})
    void getZusPension(BigDecimal input, BigDecimal expected) {
        assertThat(SalaryCalculatorEnum.PENSION_ZUS.getOperator().apply(input)).isEqualTo(expected);


    }

    @ParameterizedTest
    @CsvSource({"6000,90.00", "7000, 105.00", "15891.68, 238.38"})
    void getZusDisability(BigDecimal input, BigDecimal expected) {
        assertThat(SalaryCalculatorEnum.DISABILITY_ZUS.getOperator().apply(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 147.00", "7000, 171.50", "15891.68, 389.35"})
    void getZusSickness(BigDecimal input, BigDecimal expected) {
        assertThat(SalaryCalculatorEnum.SICKNESS_ZUS.getOperator().apply(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 72000.00", "7000, 84000.00", "15891.68, 190700.16"})
    void getYearlyGross(BigDecimal input, BigDecimal expected) {
        assertThat(SalaryCalculatorEnum.GROSS_YEARLY.getOperator().apply(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"6000, 4319.44", "7000, 5039.35", "15891.68, 10691.81"})
    void getNet(BigDecimal input, BigDecimal expected) {
        assertThat(SalaryCalculatorEnum.NET.getOperator().apply(input)).isEqualTo(expected);

    }


    @ParameterizedTest
    @CsvSource({"6000, 51833.28", "7000, 60472.20", "15891.68, 128301.72"})
    void getYearlyNet(BigDecimal input, BigDecimal expected) {
        assertThat(SalaryCalculatorEnum.NET_YEARLY.getOperator().apply(input)).isEqualTo(expected);
    }


}