package org.example.enumApproch;

import java.math.BigDecimal;

import org.example.enumApproch.menu.Menu;
import org.example.enumApproch.print.PrinterCalculator;
import org.example.enumApproch.service.JobTitleService;
import org.example.enumApproch.service.JobTitleServiceImpl;


public class MainWithEnum {

    public static void main(String[] args) {

        Menu menu = new Menu();
        PrinterCalculator printerCalculator = new PrinterCalculator();
        JobTitleService averageSalaryService = new JobTitleServiceImpl();
        BigDecimal grossMonthlySalary = menu.userInput();
        int i = averageSalaryService.save(grossMonthlySalary);
        printerCalculator.printSalaryCalculatorTax(grossMonthlySalary);
        String jobField = menu.surveyInput();
        if (jobField != null) {
            printerCalculator.printJobTitle(jobField);
            String jobTitle = menu.jobTitleValidator(jobField);
            averageSalaryService.updateJobTitle(i, jobTitle);
            BigDecimal monthlyJobFieldAverage = averageSalaryService.getAverageByJobTile(jobTitle);
            printerCalculator.printAverage(monthlyJobFieldAverage, grossMonthlySalary);
        }

    }

}
