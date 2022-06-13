package org.example.enumApproch.print;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.example.enumApproch.enums.JobFields;
import org.example.enumApproch.enums.Rates;
import org.example.enumApproch.enums.SalaryCalculatorEnum;


public class PrinterCalculator {


    public void printSalaryCalculatorTax(BigDecimal grossSalary) {
        Arrays.stream(SalaryCalculatorEnum.values())
                .forEach(values -> System.out.print(
                        "\n" + values.getDescription() + values.getOperator().apply(grossSalary)));
    }


    public void printAverage(BigDecimal average, BigDecimal grossSalary) {
        if (average != null) {
            if (average.compareTo(grossSalary.multiply(BigDecimal.valueOf(Rates.MONTH_NUMBER.getRate()))) > 0) {
                System.out.println("The monthly average is " + average.setScale(2, RoundingMode.HALF_EVEN) +
                        " and your monthly average is " + grossSalary.setScale(2, RoundingMode.HALF_EVEN) +
                        " and is below of the average");
            } else {
                System.out.println("The monthly average is " + average.setScale(2, RoundingMode.HALF_EVEN) +
                        " and your monthly average is " + grossSalary.setScale(2, RoundingMode.HALF_EVEN) +
                        " and is above of the average");
            }

        }
    }

    public void printJobFields() {
        Arrays.stream(JobFields.values())
                .forEach(jobField -> System.out.println(jobField.getJobId() + " - " + jobField.getDescription()));

    }

    public void printJobTitle(String jobField) {
        final AtomicInteger count = new AtomicInteger(1);
        Arrays.stream(JobFields.values())
                .filter(jobFields -> jobFields.equals(JobFields.valueOf(jobField.toUpperCase())))
                .forEach(jobTitle -> jobTitle.getJobTitle()
                        .forEach(x -> System.out.println(count.getAndIncrement() + " - " + x)));

    }

}
