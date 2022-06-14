package org.example.enumApproch.print;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.example.enumApproch.enums.JobsCategory;
import org.example.enumApproch.enums.SalaryCalculatorEnum;


public class PrinterSalaryCalculator {


    public void printSalaryCalculatorTax(BigDecimal grossSalary) {
        Arrays.stream(SalaryCalculatorEnum.values())
                .forEach(values -> System.out.print(
                        "\n" + values.getDescription() + values.getOperator().apply(grossSalary)));
    }


    public void printAverage(BigDecimal average, BigDecimal grossSalary) {
        if (average != null) {
            if (average.compareTo(grossSalary) > 0) {
                System.out.println("The monthly average is " + average.setScale(2, RoundingMode.HALF_EVEN) +
                        " and your monthly average is " + grossSalary.setScale(2, RoundingMode.HALF_EVEN) +
                        " and it is below of the threshold");
            } else {
                System.out.println("The monthly average is " + average.setScale(2, RoundingMode.HALF_EVEN) +
                        " and your monthly average is " + grossSalary.setScale(2, RoundingMode.HALF_EVEN) +
                        " and it is above of the threshold");
            }

        }
    }

    public void printJobFields() {
        Arrays.stream(JobsCategory.values())
                .forEach(jobField -> System.out.println(jobField.getJobId() + " - " + jobField.getDescription()));

    }

    public void printJobTitle(String jobField) {
        final AtomicInteger count = new AtomicInteger(1);
<<<<<<< HEAD:src/main/java/org/example/enumApproch/print/PrinterSalaryCalculator.java
        Arrays.stream(JobsCategory.values())
                .filter(jobFields -> jobFields.equals(JobsCategory.valueOf(jobField.toUpperCase())))
                .forEach(jobTitle -> jobTitle.getJobTitle()
                        .forEach(result -> System.out.println(count.getAndIncrement() + " - " + result)));
=======
        Arrays.stream(JobFields.values())
                .filter(jobFields -> jobFields.equals(JobFields.valueOf(jobField.toUpperCase())))
                .forEach(jobTitle -> jobTitle.getJobTitle()
                        .forEach(x -> System.out.println(count.getAndIncrement() + " - " + x)));
>>>>>>> d0006b8a8037e8b57950c27abb8e298412f14b26:src/main/java/org/example/enumApproch/print/PrinterCalculator.java

    }

}
