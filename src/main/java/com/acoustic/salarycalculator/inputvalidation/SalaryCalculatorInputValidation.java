package com.acoustic.salarycalculator.inputvalidation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.acoustic.salarycalculator.jobscategories.JobsCategory;
import com.acoustic.salarycalculator.printer.SalaryCalculatorPrinter;
import com.acoustic.salarycalculator.rates.Rates;


public class SalaryCalculatorInputValidation {

    private final Scanner scanner;
    private final SalaryCalculatorPrinter printerCalculator;

    public SalaryCalculatorInputValidation() {
        this.printerCalculator = new SalaryCalculatorPrinter();
        this.scanner = new Scanner(System.in);
    }

    public BigDecimal userInput() {
        BigDecimal grossMonthlySalary;
        do {
            System.out.println("Please enter a gross amount greater or equal to " + Rates.MINIMUM_SALARY.getRate());
            while (!scanner.hasNextBigDecimal()) {
                System.out.println("That's not a valid number, please try again: ");
                scanner.next();
            }
            grossMonthlySalary = scanner.nextBigDecimal();

        } while (grossMonthlySalary.compareTo(BigDecimal.valueOf(Rates.MINIMUM_SALARY.getRate())) < 0);
        scanner.nextLine();
        return grossMonthlySalary;
    }

    public JobsCategory surveyInput() {
        System.out.println("\nDo you want to participate to the statistic ?\nPlease type yes or y:");
        String choice;
        choice = scanner.nextLine();
        if (choice.trim().equalsIgnoreCase("yes") || choice.trim().equalsIgnoreCase("y")) {
            printerCalculator.printJobDepartment();
            return getJobCategory();
        } else {
            System.out.println("Thank you for using salary calculator");
            return null;
        }

    }

    private JobsCategory getJobCategory() {
        while (true) {
            try {
                System.out.println("Please enter the job department id: ");
                int jobDepartmentId = scanner.nextInt();
                return Arrays.stream(JobsCategory.values())
                        .filter(jobCategory -> jobCategory.getJobId() == jobDepartmentId)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
            } catch (IllegalArgumentException | InputMismatchException | NullPointerException exception) {
                System.out.println("Invalid job department id, please try again");
                scanner.nextLine();
            }
        }
    }


    public String jobTitleValidator(JobsCategory jobsCategory) {
        while (true) {
            try {
                System.out.println("Please enter the job title id: ");
                int jobTitleId = scanner.nextInt();
                return jobsCategory
                        .getJobTitle()
                        .get(jobTitleId - 1);

            } catch (IllegalArgumentException | InputMismatchException | NullPointerException  | ArrayIndexOutOfBoundsException exception) {
                System.out.println("Invalid job title id, please try again");
                scanner.nextLine();
            }
        }

    }

}
