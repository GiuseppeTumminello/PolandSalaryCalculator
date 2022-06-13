package org.example.enumApproch.menu;

import java.math.BigDecimal;
import java.util.Scanner;


public class Menu {


    private final Scanner scanner;


    public Menu() {
        this.scanner = new Scanner(System.in);
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
                    return jobTileValidator();
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

    private String jobTileValidator() {
        while (true) {
            System.out.println("Please enter a job: ");
            String jobTitle = scanner.nextLine();
            if (!jobTitle.matches("\\d+") && jobTitle.length() >= 4) {
                return jobTitle.trim().toLowerCase().replaceAll("[\\s-]", "");
            } else {
                System.out.println("The job title cannot be a number and has to be greater than or equal to four ");
            }
        }
    }

}
