package com.acoustic.salarycalculator.menu;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import com.acoustic.salarycalculator.jobscategories.JobsCategory;
import com.acoustic.salarycalculator.printer.SalaryCalculatorPrinter;
import com.acoustic.salarycalculator.rates.Rates;


public class SalaryCalculatorMenu {

    private Scanner scanner;
    private final SalaryCalculatorPrinter printerCalculator;

    public SalaryCalculatorMenu() {
        this.printerCalculator = new SalaryCalculatorPrinter();
        this.scanner = new Scanner(System.in);
    }

    public BigDecimal userInput() {
        Scanner scanner = new Scanner(System.in);
        BigDecimal grossMonthlySalary;
        do {
            System.out.println("Please enter a gross amount greater or equal to 2000.00");
            while (!scanner.hasNextBigDecimal()) {
                System.out.println("That's not a valid number, please try again: ");
                scanner.next();
            }
            grossMonthlySalary = scanner.nextBigDecimal();

        } while (grossMonthlySalary.compareTo(BigDecimal.valueOf(Rates.MINIMUM_SALARY.getRate())) < 0);


        return grossMonthlySalary;
    }

    public int surveyInput() {

        System.out.println("\nDo you want to participate to the statistic ?\nPlease type yes or y:");
        String choice;
        choice = scanner.nextLine();
        if (choice.trim().equalsIgnoreCase("yes") || choice.trim().equalsIgnoreCase("y")) {
            printerCalculator.printJobFields();
            return jobDepartmentValidator();
        } else {
            System.out.println("Thank you for using salary calculator");
        }
        return 0;
    }

    private int jobDepartmentValidator() {
        while (true) {
            try {
                System.out.println("Please enter a job field id: ");
                int jobField = scanner.nextInt();
                return Arrays.stream(JobsCategory.values())
                        .map(JobsCategory::getJobId)
                        .filter(jobId -> jobId == jobField)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
            } catch (Exception e) {
                System.out.println("Invalid job department id, please try again");
                scanner.nextLine();
            }
        }
    }


    public String jobTitleValidator(int jobField) {
        while (true) {
            try {
                System.out.println("Please enter a job title: ");
                int jobTitleId = scanner.nextInt();
                return Arrays.stream(JobsCategory.values())
                        .map(x -> x.getJobTitle().get(jobTitleId))
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
            } catch (Exception e) {

                System.out.println("Invalid job title, please try again");
                scanner.nextLine();
            }
        }

    }

}
