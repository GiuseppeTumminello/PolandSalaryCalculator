package org.example.enumApproch;

import org.example.enumApproch.Service.DatabaseServiceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class MainWithEnum {

    public static void main(String[] args){




        var salary = userInput();
        DatabaseServiceImpl databaseService = new DatabaseServiceImpl();

        System.out.println(databaseService.getDataByJobTitle("software engineer", "junior"));

        for (var values : SalaryCalculatorEnum.values()) {
            System.out.print("\n" + values.getDescription());
            System.out.print(values.getOperator().apply(salary));
        }


    }


    public static BigDecimal userInput() {
        BigDecimal grossSalary;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a gross amount greater or equal to 2000.00");
            while (!scanner.hasNextBigDecimal()) {
                System.out.println("That's not a valid number, please try again: ");
                scanner.next();
            }

            grossSalary = scanner.nextBigDecimal();


        } while (grossSalary.compareTo(new BigDecimal("2000.00")) < 0);

        return grossSalary;
    }
}
