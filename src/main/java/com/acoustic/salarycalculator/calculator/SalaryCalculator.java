package com.acoustic.salarycalculator.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.UnaryOperator;

import com.acoustic.salarycalculator.rates.Rates;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum SalaryCalculator {
    PENSION_ZUS(getAmountByRate(Rates.PENSION_ZUS_RATE), "Pension Zus amount: "),
    DISABILITY_ZUS(getAmountByRate(Rates.DISABILITY_ZUS_RATE), "Disability zus amount: "),
    SICKNESS_ZUS(getAmountByRate(Rates.SICKNESS_ZUS_RATE), "Sickness zus amount: "),
    TOTAL_ZUS(getAmountByRate(Rates.TOTAL_ZUS_RATE), "Total zus amount: "),
    HEALTH(getHealth(), "Health amount: "),
    GROSS_YEARLY(getAmountByRate(Rates.MONTH_NUMBER), "Yearly gross amount: "),
    TAX(getTaxAmount(), "Tax amount: "),

    NET(getNet(), "Net amount: "),
    NET_YEARLY(getNetYearly(), "Yearly net amount: "),
    GROSS_MONTHLY(gross -> gross.setScale(2, RoundingMode.HALF_EVEN), "Monthly gross amount: ");

    private final UnaryOperator<BigDecimal> operator;
    private final String description;

    private static UnaryOperator<BigDecimal> getAmountByRate(Rates rate) {
        return gross -> gross.multiply(BigDecimal.valueOf(rate.getRate())).setScale(2, RoundingMode.HALF_EVEN);
    }


    private static UnaryOperator<BigDecimal> getHealth() {
        return gross -> gross.subtract(TOTAL_ZUS.getOperator().apply(gross))
                .multiply(BigDecimal.valueOf(Rates.HEALTH_RATE.getRate()))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    private static UnaryOperator<BigDecimal> getNet() {
        return gross -> gross.subtract(TOTAL_ZUS.operator.apply(gross)
                        .add((TAX.operator.apply(gross)).add(HEALTH.operator.apply(gross))))
                .setScale(2, RoundingMode.HALF_EVEN);
    }


    private static UnaryOperator<BigDecimal> getNetYearly() {
        return gross -> NET.getOperator()
                .apply(gross)
                .multiply(BigDecimal.valueOf(Rates.MONTH_NUMBER.getRate()))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    private static UnaryOperator<BigDecimal> getTaxAmount() {
        return gross -> {
            if (GROSS_YEARLY.getOperator()
                    .apply(gross)
                    .compareTo(BigDecimal.valueOf(Rates.TAX_GROSS_AMOUNT_TRASHOLD.getRate())) < 0) {
                return gross.subtract(TOTAL_ZUS.getOperator().apply(gross))
                        .subtract(HEALTH.getOperator().apply(gross))
                        .multiply(BigDecimal.valueOf(Rates.TAX_RATE_17.getRate()))
                        .setScale(2, RoundingMode.HALF_EVEN);
            } else {
                return gross.subtract(TOTAL_ZUS.getOperator().apply(gross))
                        .subtract(HEALTH.getOperator().apply(gross))
                        .multiply(BigDecimal.valueOf(Rates.TAX_RATE_32.getRate()))
                        .setScale(2, RoundingMode.HALF_EVEN);

            }
        };
    }

}
