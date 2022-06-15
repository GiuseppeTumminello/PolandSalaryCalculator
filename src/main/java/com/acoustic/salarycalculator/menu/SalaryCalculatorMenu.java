package com.acoustic.salarycalculator.menu;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.acoustic.salarycalculator.jobscategories.JobsCategory;
import com.acoustic.salarycalculator.printer.SalaryCalculatorPrinter;
import com.acoustic.salarycalculator.rates.Rates;


public class SalaryCalculatorMenu {

    private final Scanner scanner;
    private final SalaryCalculatorPrinter printerCalculator;

    public SalaryCalculatorMenu() {
        this.printerCalculator = new SalaryCalculatorPrinter();
        this.scanner = new Scanner(System.in);
    }

    public BigDecimal userInput() {
        BigDecimal grossMonthlySalary;
        do {
            System.out.println("Please enter a gross amount greater or equal to 2000.00");
            while (!scanner.hasNextBigDecimal()) {
                System.out.println("That's not a valid number, please try again: ");
                scanner.next();
            }
            grossMonthlySalary = scanner.nextBigDecimal();

        } while (grossMonthlySalary.compareTo(BigDecimal.valueOf(Rates.MINIMUM_SALARY.getRate())) < 0);
        scanner.nextLine();
        return grossMonthlySalary;
    }

    public int surveyInput() {
        System.out.println("\nDo you want to participate to the statistic ?\nPlease type yes or y:");
        String choice;
        choice = scanner.nextLine();
        if (choice.trim().equalsIgnoreCase("yes") || choice.trim().equalsIgnoreCase("y")) {
            printerCalculator.printJobDepartment();
            return jobDepartmentValidator();
        } else {
            System.out.println("Thank you for using salary calculator");
        }
        return 0;
    }

    private int jobDepartmentValidator() {
        while (true) {
            try {
                System.out.println("Please enter the job department id: ");
                int jobDepartmentId = scanner.nextInt();
                return Arrays.stream(JobsCategory.values())
                        .map(JobsCategory::getJobId)
                        .filter(jobCategoryId -> jobCategoryId == jobDepartmentId)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
            } catch (IllegalArgumentException | InputMismatchException | NullPointerException exception) {
                System.out.println("Invalid job department id, please try again");
                scanner.nextLine();
            }
        }
    }


    public String jobTitleValidator(int jobDepartmentId) {
        while (true) {
            try {
                System.out.println("Please enter a job title: ");
                int jobTitleId = scanner.nextInt();
                return Arrays.stream(JobsCategory.values())
                        .filter(jobCategory -> jobCategory.getJobId() == jobDepartmentId &&
                                jobCategory.getJobTitle().size() >= jobTitleId && jobTitleId >= 1)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new)
                        .getJobTitle()
                        .get(jobTitleId);

            } catch (IllegalArgumentException | InputMismatchException | NullPointerException e) {
                System.out.println("Invalid job title id, please try again");
                scanner.nextLine();
            }
        }

    }

}
