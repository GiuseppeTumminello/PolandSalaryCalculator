package org.example.enumApproch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.UnaryOperator;

public enum SalaryCalculatorEnum {

    PENSION_ZUS(gross ->  gross.multiply(BigDecimal.valueOf(0.0976d)).setScale(2, RoundingMode.HALF_EVEN), "Pension Zus amount:"),
    DISABILITY_ZUS(gross -> gross.multiply(BigDecimal.valueOf(0.0150d)).setScale(2, RoundingMode.HALF_EVEN), "Disability zus amount: "),
    SICKNESS_ZUS(gross -> gross.multiply(BigDecimal.valueOf(0.0245d)).setScale(2, RoundingMode.HALF_EVEN), "Sickness zus amount: "),
    TOTAL_ZUS(gross -> gross.multiply(BigDecimal.valueOf(0.1371)).setScale(2, RoundingMode.HALF_EVEN), "Total zus amount: "),
    HEALTH(gross -> gross.subtract(TOTAL_ZUS.getOperator().apply(gross)).multiply(BigDecimal.valueOf(0.09)).setScale(2, RoundingMode.HALF_EVEN), "Health amount: "),
    GROSS_YEARLY(gross -> gross.multiply(BigDecimal.valueOf(12)).setScale(2, RoundingMode.HALF_EVEN), "Yearly gross amount: "),
    TAX(gross -> {
        if (GROSS_YEARLY.getOperator().apply(gross).compareTo(BigDecimal.valueOf(120000)) < 0)
            return gross.subtract(TOTAL_ZUS.getOperator().apply(gross)).subtract(HEALTH.getOperator().apply(gross)).multiply(BigDecimal.valueOf(0.0832)).setScale(2, RoundingMode.HALF_EVEN);
        else return gross.subtract(TOTAL_ZUS.getOperator().apply(gross)).subtract(HEALTH.getOperator().apply(gross)).multiply(BigDecimal.valueOf(0.1432)).setScale(2, RoundingMode.HALF_EVEN);
    }, "Tax amount: "),


    NET(gross -> gross.subtract(TOTAL_ZUS.operator.apply(gross).add((TAX.operator.apply(gross)).add(HEALTH.operator.apply(gross)))).setScale(2, RoundingMode.HALF_EVEN), "Net amount: "),
    NET_YEARLY(gross -> NET.getOperator().apply(gross).multiply(BigDecimal.valueOf(12.)).setScale(2, RoundingMode.HALF_EVEN), "Yearly net amount: ");

    private final UnaryOperator<BigDecimal> operator;
    private final String description;

    SalaryCalculatorEnum(UnaryOperator<BigDecimal> operator, String description) {

        this.operator = operator;
        this.description = description;
    }

    public UnaryOperator<BigDecimal> getOperator() {
        return operator;
    }

    public String getDescription() {
        return description;
    }


}
