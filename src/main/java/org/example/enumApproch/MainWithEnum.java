package org.example.enumApproch;

import java.math.BigDecimal;

import org.example.enumApproch.menu.MenuSalaryCalculator;
import org.example.enumApproch.print.PrinterSalaryCalculator;
import org.example.enumApproch.service.JobTitleService;
import org.example.enumApproch.service.JobTitleServiceImpl;


public class MainWithEnum {

    public static void main(String[] args) {

        MenuSalaryCalculator menu = new MenuSalaryCalculator();
        PrinterSalaryCalculator printerCalculator = new PrinterSalaryCalculator();
        JobTitleService averageSalaryService = new JobTitleServiceImpl();
        BigDecimal grossMonthlySalary = menu.userInput();
        int id = averageSalaryService.save(grossMonthlySalary);
        printerCalculator.printSalaryCalculatorTax(grossMonthlySalary);
        String jobField = menu.surveyInput();
        if (jobField != null) {
            printerCalculator.printJobTitle(jobField);
            String jobTitle = menu.jobTitleValidator(jobField);
            averageSalaryService.updateJobTitle(id, jobTitle);
            BigDecimal monthlyJobFieldAverage = averageSalaryService.getAverageByJobTile(jobTitle);
            printerCalculator.printAverage(monthlyJobFieldAverage, grossMonthlySalary);
        }

    }

}
