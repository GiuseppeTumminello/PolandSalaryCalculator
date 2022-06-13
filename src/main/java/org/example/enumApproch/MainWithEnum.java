package org.example.enumApproch;

import java.math.BigDecimal;

import org.example.enumApproch.menu.Menu;
import org.example.enumApproch.print.PrinterCalculator;
import org.example.enumApproch.service.JobTitleServiceImpl;


public class MainWithEnum {

    public static void main(String[] args) {

        Menu menu = new Menu();
        PrinterCalculator printerCalculator = new PrinterCalculator();
        JobTitleServiceImpl averageSalaryService = new JobTitleServiceImpl();
        BigDecimal grossSalary = menu.userInput();
        int i = averageSalaryService.save(grossSalary);
        printerCalculator.printSalaryCalculatorTax(grossSalary);
        String jobTile = menu.surveyInput();
        if (jobTile != null) {
            averageSalaryService.updateJobTitle(i, jobTile);
            BigDecimal average = averageSalaryService.getAverageByJobTile(jobTile);
            printerCalculator.printAverage(average, grossSalary);
        }

    }

}
