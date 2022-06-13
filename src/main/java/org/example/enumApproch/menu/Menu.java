package org.example.enumApproch.menu;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import org.example.enumApproch.enums.JobFields;
import org.example.enumApproch.print.PrinterCalculator;


public class Menu {

    private final Scanner scanner;
    private final PrinterCalculator printerCalculator;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.printerCalculator = new PrinterCalculator();

    }

    public BigDecimal userInput() {
        BigDecimal grossSalary;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter a gross amount greater or equal to 2000.00");
            while (!scanner.hasNextBigDecimal()) {
                System.out.println("That's not a valid number, please try again: ");
                scanner.next();
            }
            grossSalary = scanner.nextBigDecimal();

        } while (grossSalary.compareTo(new BigDecimal("2000.00")) < 0);


        return grossSalary;
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
                return Arrays.stream(JobFields.values())
                        .map(JobFields::getDescription)
                        .filter(description -> description.equalsIgnoreCase(jobField.trim()))
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid job, please try again");
            }
        }
    }

    public String jobTitleValidator(String jobField){
        while(true) {
            try {
                 System.out.println("Please enter a job title: ");
                 String jobTitle = scanner.nextLine();
                for (JobFields jobFields : JobFields.values()){
                    if (jobFields.equals(JobFields.valueOf(jobField.toUpperCase()))) {
                        for (var enumJobTitle : jobFields.getJobTitle()) {
                            if (enumJobTitle.equalsIgnoreCase(jobTitle.trim())){
                                return enumJobTitle;
                            }
                        }
                    }
                }
                throw new IllegalArgumentException();

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid job, please try again");
            }
        }


    }

}
