package org.example.MapApproch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.UnaryOperator;


public class SalaryCalculatorMap {

    private final Map<Operation, UnaryOperator<BigDecimal>> operation;

    public SalaryCalculatorMap() {
        this.operation = new LinkedHashMap<>();
        this.operation.put(
                Operation.PENSION_ZUS,
                gross -> gross.multiply(BigDecimal.valueOf(0.0976d)).setScale(2, RoundingMode.HALF_EVEN));
        this.operation.put(
                Operation.DISABILITY_ZUS,
                gross -> gross.multiply(BigDecimal.valueOf(0.0976d)).setScale(2, RoundingMode.HALF_EVEN));
        this.operation.put(
                Operation.SICKNESS_ZUS,
                gross -> gross.multiply(BigDecimal.valueOf(0.0150d)).setScale(2, RoundingMode.HALF_EVEN));
        this.operation.put(
                Operation.TOTAL_ZUS,
                gross -> gross.multiply(BigDecimal.valueOf(0.1371)).setScale(2, RoundingMode.HALF_EVEN));
        this.operation.put(
                Operation.HEALTH,
                gross -> gross.subtract(operation.get(Operation.TOTAL_ZUS).apply(gross))
                        .multiply(BigDecimal.valueOf(0.09))
                        .setScale(2, RoundingMode.HALF_EVEN));

    }

    public void setOperation(Operation op, UnaryOperator<BigDecimal> unaryOperator) {
        this.operation.put(op, unaryOperator);
    }

    public Map<Operation, UnaryOperator<BigDecimal>> getOperation() {
        return operation;
    }
}
