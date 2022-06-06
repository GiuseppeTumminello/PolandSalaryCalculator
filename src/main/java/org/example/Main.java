package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NetCalculator netCalculator = new NetCalculator();

        double number;
        do {
            System.out.println("Please enter a gross amount");
            while (!scanner.hasNextDouble()) {
                System.out.println("That's not a valid number, please try again: ");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0.0);
        netCalculator.setGross(number);
        System.out.println();
        System.out.println("The net amount of the gross value of " + netCalculator.getGross() + " is " + netCalculator.getNet() +
                "\nThe employee zus costs are as follow: " +
                "\nZus pension: " + netCalculator.getZusPension() + ", rate: " + netCalculator.getZusPensionRate() +
                "\nZus disability: " + netCalculator.getZusPension() + ", rate: " + netCalculator.getZusDisabilityRate() +
                "\nZus sickness:  " + netCalculator.getZusSickness() + ", rate " + netCalculator.getZusSicknessRate() +
                "\nTotal Cost Zus: " + netCalculator.getZusTotal() +
                "\nThe health cost is: " + netCalculator.getHealthNfzTotal() + ", rate:  " + netCalculator.getHealthNFZRate() +
                "\nThe tax advanced pay total is: " + netCalculator.getAdvancePaymentTotal() +
                "\nThe annual gross sum is: " + netCalculator.getAnnualSum() + " the rate applied is: " + netCalculator.getTaxRate() + "%" +
                "\nThe annual net sum is: " + netCalculator.getNet() * 12


        );


    }
}
