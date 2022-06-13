package org.example.enumApproch.print;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.example.enumApproch.SalaryCalculatorEnum;


public class PrinterCalculator {


    public void printSalaryCalculatorTax(BigDecimal grossSalary) {
        for (var values : SalaryCalculatorEnum.values()) {
            System.out.print("\n" + values.getDescription());
            System.out.print(values.getOperator().apply(grossSalary));
        }
    }


    public void printAverage(BigDecimal average, BigDecimal grossSalary) {
        if (average != null) {
            if (average.compareTo(grossSalary.multiply(BigDecimal.valueOf(12))) < 0){
                System.out.println("The monthly average is " + average.setScale(2, RoundingMode.HALF_EVEN) + " and your monthly average is " + grossSalary + " and is below of the average");
            }
            System.out.println("The monthly average is " + average.setScale(2, RoundingMode.HALF_EVEN) + " and your monthly average is " + grossSalary + " and is above of the average");

        } else {
            System.out.println("We do not have enough data to provide the average or the job title does not exist");
        }
    }

}
