package org.example.enumApproch;

import org.example.enumApproch.Service.AverageSalaryServiceImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainWithEnum {

    public static void main(String[] args) {
        BigDecimal grossSalary = userInput();
        for (var values : SalaryCalculatorEnum.values()) {
            System.out.print("\n" + values.getDescription());
            System.out.print(values.getOperator().apply(grossSalary) + "\n");
        }

        checkAverage(grossSalary);


    }


    public static BigDecimal userInput() {
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

    public static void checkAverage(BigDecimal grossSalary) {
        AverageSalaryServiceImpl averageSalaryService = new AverageSalaryServiceImpl();
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter 1 - to check the average \nPlease enter 2 - to exit ");
            while (!scanner.hasNextBigDecimal()) {
                System.out.println("That's not a valid number, please try again: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int jobId;
                    do {
                        System.out.println("Enter 1 - software engineer" +
                                "\nEnter 2 - for project manager" +
                                "\nEnter 3 - for scum " +
                                "\nEnter 4 -for fund accounting" +
                                "\n" + "Enter 5 - DevOps engineer");
                        while (!scanner.hasNextInt()) {
                            System.out.println("That's not a valid number, please try again: ");
                            scanner.next();
                        }
                        jobId = scanner.nextInt();


                    } while (jobId > 5 || jobId < 1);
                    BigDecimal averageSalary = averageSalaryService.getById(jobId);
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
