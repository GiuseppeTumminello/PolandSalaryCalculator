package org.example.enumApproch.menu;

import org.example.enumApproch.service.JobTitleServiceImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    private final JobTitleServiceImpl averageSalaryService;

    public Menu() {
        this.averageSalaryService = new JobTitleServiceImpl();
    }

    public  BigDecimal userInput() {
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

    public  void checkAverage(BigDecimal grossSalary) {


        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nPlease enter 1 - to check the average \nPlease enter 2 - to exit ");
            while (!scanner.hasNextBigDecimal()) {
                System.out.println("That's not a valid number, please try again: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int jobId;
                    do {

                        while (!scanner.hasNextInt()) {
                            System.out.println("That's not a valid number, please try again: ");
                            scanner.next();
                        }
                        jobId = scanner.nextInt();


                    } while (jobId > 5 || jobId < 1);
                    BigDecimal averageSalary = averageSalaryService.getJobTitleById(jobId).getGrossAverage();
                    if (averageSalary.compareTo(grossSalary.multiply(BigDecimal.valueOf(12))) < 0) {
                        System.out.println("Your salary is greater than " + averageSalary + " yearly");
                    } else {
                        System.out.println("Your salary is less than " + averageSalary + " yearly");
                    }
                    break;
                case 2:
                    System.out.println("Thank you for using the salary calculator, bye!!");
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (choice > 2 || choice <= 0);
    }

}
