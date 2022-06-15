package com.acoustic.salarycalculator.printer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;

import com.acoustic.salarycalculator.calculator.SalaryCalculator;
import com.acoustic.salarycalculator.jobscategories.JobsCategory;


public class SalaryCalculatorPrinter {


    public void printSalaryCalculatorTax(BigDecimal grossMonthlySalary) {
        Arrays.stream(SalaryCalculator.values())
                .forEach(values -> System.out.print(
                        "\n" + values.getDescription() + values.getOperator().apply(grossMonthlySalary)));
    }


    public void printAverage(BigDecimal monthlyAverage, BigDecimal grossMonthlySalary) {
        if (monthlyAverage != null) {
            if (monthlyAverage.compareTo(grossMonthlySalary) > 0) {
                printAverageHelper(monthlyAverage, grossMonthlySalary, "below");
            } else if (monthlyAverage.compareTo(grossMonthlySalary) == 0) {
                printAverageHelper(monthlyAverage, grossMonthlySalary, "equal to");
            } else {
                printAverageHelper(monthlyAverage, grossMonthlySalary, "above");
            }

        }
    }

    private void printAverageHelper(BigDecimal monthlyAverage, BigDecimal grossMonthlySalary, String equality) {
        System.out.println("The monthly gross average is " + monthlyAverage.setScale(2, RoundingMode.HALF_EVEN) +
                " and your monthly gross is " + grossMonthlySalary.setScale(2, RoundingMode.HALF_EVEN) + " and it is " +
                equality + " the threshold");
    }


    public void printJobFields() {
        Arrays.stream(JobsCategory.values())
                .forEach(jobField -> System.out.println(jobField.getJobId() + " - " + jobField.getDescription()));

    }

    public void printJobTitle(int jobFieldId) {
        Arrays.stream(JobsCategory.values())
                .filter(x -> x.getJobId() == jobFieldId)
                .findFirst()
                .get()
                .getJobTitle()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(x -> System.out.println(x.getKey() + " - " + x.getValue()));




    }

}
