package org.example.MapApproch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.function.UnaryOperator;


public class MapMain {


    public static void main(String[] args) {
        BigDecimal salary = BigDecimal.valueOf(6000.00);
        SalaryCalculatorMap salaryCalculatorMap = new SalaryCalculatorMap();
        salaryCalculatorMap.setOperation(Operation.GROSS_YEARLY, gross -> gross.multiply(BigDecimal.valueOf(12)));
        salaryCalculatorMap.setOperation(Operation.TAX, gross -> {
            if (salaryCalculatorMap.getOperation()
                    .get(Operation.GROSS_YEARLY)
                    .apply(gross)
                    .compareTo(BigDecimal.valueOf(120000)) < 0) {
                return gross.subtract(salaryCalculatorMap.getOperation().get(Operation.TOTAL_ZUS).apply(gross))
                        .subtract(salaryCalculatorMap.getOperation().get(Operation.HEALTH).apply(gross))
                        .multiply(BigDecimal.valueOf(0.0832))
                        .setScale(2, RoundingMode.HALF_EVEN);
            } else {
                return gross.subtract(salaryCalculatorMap.getOperation().get(Operation.TOTAL_ZUS).apply(gross))
                        .subtract(salaryCalculatorMap.getOperation().get(Operation.HEALTH).apply(gross))
                        .multiply(BigDecimal.valueOf(0.1432))
                        .setScale(2, RoundingMode.HALF_EVEN);
            }
        });

        for (Map.Entry<Operation, UnaryOperator<BigDecimal>> item : salaryCalculatorMap.getOperation().entrySet()) {
            System.out.println(item.getKey().getDescription() + " " + item.getValue().apply(salary));
        }

    }

}
