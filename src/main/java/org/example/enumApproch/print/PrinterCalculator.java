package org.example.enumApproch.print;

import java.math.BigDecimal;

import org.example.enumApproch.SalaryCalculatorEnum;


public class PrinterCalculator {



    public void printSalaryCalculatorTax(BigDecimal grossSalary) {
        for (var values : SalaryCalculatorEnum.values()) {
            System.out.print("\n" + values.getDescription());
            System.out.print(values.getOperator().apply(grossSalary));
        }
    }


    public void printAverage(BigDecimal average) {
        if (average != null) {
            System.out.println("Average is: " + average);
        } else {
            System.out.println("We do not have enough data to provide the average or the job title does not exist");
        }
    }


}
