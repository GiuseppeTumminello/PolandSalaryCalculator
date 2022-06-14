package com.acoustic.salarycalculator.menu;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import com.acoustic.salarycalculator.jobscategories.JobsCategory;
import com.acoustic.salarycalculator.printer.SalaryCalculatorPrinter;


public class SalaryCalculatorMenu {

    private final Scanner scanner;
    private final SalaryCalculatorPrinter printerCalculator;

    public SalaryCalculatorMenu() {
        this.scanner = new Scanner(System.in);
        this.printerCalculator = new SalaryCalculatorPrinter();

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

        } while (grossMonthlySalary.compareTo(new BigDecimal("2000.00")) < 0);


        return grossMonthlySalary;
    }

    public String surveyInput() {
        System.out.println("\nDo you want to participate to the statistic ?\nPlease type yes or no:");
        String choice;
        while (true) {
            try {
                choice = scanner.nextLine();
                if (choice.trim().equalsIgnoreCase("yes")) {
                    printerCalculator.printJobFields();
                    return jobFieldValidator();
                } else if (choice.trim().equalsIgnoreCase("no")) {
                    System.out.println("Thank you for using Salary Calculator");
                    return null;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong input, please try again: ");
            }
        }
    }

    private String jobFieldValidator() {
        while (true) {
            try {
                System.out.println("Please enter a job field: ");
                String jobField = scanner.nextLine();
                return Arrays.stream(JobsCategory.values())
                        .map(JobsCategory::getDescription)
                        .filter(description -> description.equalsIgnoreCase(jobField.trim()))
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid job field, please try again");
            }
        }
    }

    public String jobTitleValidator(String jobField) {
        while (true) {
            try {
                System.out.println("Please enter a job title: ");
                String jobTitle = scanner.nextLine();
                for (var jobFields : JobsCategory.values()) {
                    if (jobFields.equals(JobsCategory.valueOf(jobField.toUpperCase()))) {
                        for (var enumJobTitle : jobFields.getJobTitle()) {
                            if (enumJobTitle.equalsIgnoreCase(jobTitle.trim())) {
                                return enumJobTitle;
                            }
                        }
                    }
                }

                throw new IllegalArgumentException();

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid job title, please try again");
            }
        }

    }

}
