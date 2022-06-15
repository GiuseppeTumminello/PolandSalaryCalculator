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
    PENSION_ZUS(gross -> gross.multiply(BigDecimal.valueOf(Rates.PENSION_ZUS_RATE.getRate()))
            .setScale(2, RoundingMode.HALF_EVEN), "Pension Zus amount: "),
    DISABILITY_ZUS(gross -> gross.multiply(BigDecimal.valueOf(Rates.DISABILITY_ZUS_RATE.getRate()))
            .setScale(2, RoundingMode.HALF_EVEN), "Disability zus amount: "),
    SICKNESS_ZUS(gross -> gross.multiply(BigDecimal.valueOf(Rates.SICKNESS_ZUS_RATE.getRate()))
            .setScale(2, RoundingMode.HALF_EVEN), "Sickness zus amount: "),
    TOTAL_ZUS(gross -> gross.multiply(BigDecimal.valueOf(Rates.TOTAL_ZUS_RATE.getRate()))
            .setScale(2, RoundingMode.HALF_EVEN), "Total zus amount: "),
    HEALTH(gross -> gross.subtract(TOTAL_ZUS.getOperator().apply(gross))
            .multiply(BigDecimal.valueOf(Rates.HEALTH_RATE.getRate()))
            .setScale(2, RoundingMode.HALF_EVEN), "Health amount: "),
    GROSS_YEARLY(gross -> gross.multiply(BigDecimal.valueOf(Rates.MONTH_NUMBER.getRate()))
            .setScale(2, RoundingMode.HALF_EVEN), "Yearly gross amount: "),
    TAX(getTaxAmount(), "Tax amount: "),


    NET(gross -> gross.subtract(TOTAL_ZUS.operator.apply(gross)
                    .add((TAX.operator.apply(gross)).add(HEALTH.operator.apply(gross))))
            .setScale(2, RoundingMode.HALF_EVEN), "Net amount: "),
    NET_YEARLY(gross -> NET.getOperator()
            .apply(gross)
            .multiply(BigDecimal.valueOf(Rates.MONTH_NUMBER.getRate()))
            .setScale(2, RoundingMode.HALF_EVEN), "Yearly net amount: "),
    GROSS_MONTHLY(gross -> gross.setScale(2, RoundingMode.HALF_EVEN), "Monthly gross amount: ");

     private static  UnaryOperator<BigDecimal> getTaxAmount() {
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

    private final UnaryOperator<BigDecimal> operator;
    private final String description;

}
