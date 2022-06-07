package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal gross;

        do {
            System.out.println("Please enter a gross amount greater or equal to 2000.00");
            while (!scanner.hasNextBigDecimal()) {
                System.out.println("That's not a valid number, please try again: ");
                scanner.next();
            }

            gross = scanner.nextBigDecimal();
        } while (gross.compareTo(new BigDecimal("2000.00")) < 0);
        SalaryCalculator salaryCalculator = new SalaryCalculator(gross);
        System.out.println();
        System.out.println("The net amount of the gross value of " + salaryCalculator.getGross() + " is " + salaryCalculator.getNet() +
                "\nThe employee zus costs are as follow: " +
                "\nZus pension: " + salaryCalculator.getZusPension() + ", rate: " + salaryCalculator.getZusPensionRate() +
                "\nZus disability: " + salaryCalculator.getZusDisability() + ", rate: " + salaryCalculator.getZusDisabilityRate() +
                "\nZus sickness:  " + salaryCalculator.getZusSickness() + ", rate " + salaryCalculator.getZusSicknessRate() +
                "\nTotal Cost Zus: " + salaryCalculator.getZusTotal() +
                "\nThe health cost is: " + salaryCalculator.getHealthNfzTotal() + ", rate:  " + salaryCalculator.getHealthNFZRate() +
                "\nThe tax advanced pay total is: " + salaryCalculator.getAdvancePaymentTotal() +
                "\nThe annual gross sum is: " + salaryCalculator.getAnnualSum() + " the rate applied is: " + salaryCalculator.getTaxRate() + "%" +
                "\nThe annual net sum is: " + salaryCalculator.getNet().multiply(BigDecimal.valueOf(12.0))


        );

    }



}
