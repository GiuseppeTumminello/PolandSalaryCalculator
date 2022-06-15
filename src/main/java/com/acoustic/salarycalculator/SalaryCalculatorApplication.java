package com.acoustic.salarycalculator;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.acoustic.salarycalculator.menu.SalaryCalculatorMenu;
import com.acoustic.salarycalculator.printer.SalaryCalculatorPrinter;
import com.acoustic.salarycalculator.service.JobTitleService;
import com.acoustic.salarycalculator.service.JobTitleServiceImpl;


public class SalaryCalculatorApplication {

    public static void main(String[] args) throws SQLException {

        SalaryCalculatorMenu menu = new SalaryCalculatorMenu();
        SalaryCalculatorPrinter printerCalculator = new SalaryCalculatorPrinter();
        JobTitleService averageSalaryService = new JobTitleServiceImpl();
        BigDecimal grossMonthlySalary = menu.userInput();
        int id = averageSalaryService.save(grossMonthlySalary);
        printerCalculator.printSalaryCalculatorTax(grossMonthlySalary);
        int jobField = menu.surveyInput();
        if (jobField != 0) {
            printerCalculator.printJobTitle(jobField);
            String jobTitle = menu.jobTitleValidator(jobField);
            averageSalaryService.updateJobTitle(id, jobTitle);
            BigDecimal monthlyJobFieldAverage = averageSalaryService.getAverageByJobTile(jobTitle);
            printerCalculator.printAverage(monthlyJobFieldAverage, grossMonthlySalary);
        }

    }

}
