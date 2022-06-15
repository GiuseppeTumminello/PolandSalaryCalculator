package com.acoustic.salarycalculator;

import java.math.BigDecimal;

import com.acoustic.salarycalculator.menu.SalaryCalculatorMenu;
import com.acoustic.salarycalculator.printer.SalaryCalculatorPrinter;
import com.acoustic.salarycalculator.service.JobTitleService;
import com.acoustic.salarycalculator.service.JobTitleServiceImpl;


public class SalaryCalculatorApplication {

    SalaryCalculatorMenu menu;
    SalaryCalculatorPrinter printerCalculator;
    JobTitleService averageSalaryService;

    public SalaryCalculatorApplication() {

        this.menu = new SalaryCalculatorMenu();
        this.printerCalculator = new SalaryCalculatorPrinter();
        averageSalaryService = new JobTitleServiceImpl();
    }

    public static void main(String[] args) {
        SalaryCalculatorApplication salaryCalculatorApplication = new SalaryCalculatorApplication();
        BigDecimal grossMonthlySalary = salaryCalculatorApplication.salaryCalculator();
        salaryCalculatorApplication.survey(grossMonthlySalary);

    }

    private BigDecimal salaryCalculator() {
        BigDecimal grossMonthlySalary = menu.userInput();
        printerCalculator.printSalaryCalculatorTax(grossMonthlySalary);
        survey(grossMonthlySalary);
        return grossMonthlySalary;
    }

    private void survey(
            final BigDecimal grossMonthlySalary) {
        int jobFieldId = menu.surveyInput();
        if (jobFieldId != 0) {
            printerCalculator.printJobTitle(jobFieldId);
            String jobTitle = menu.jobTitleValidator(jobFieldId);
            averageSalaryService.save(grossMonthlySalary, jobTitle);
            BigDecimal monthlyJobFieldAverage = averageSalaryService.getAverageByJobTile(jobTitle);
            printerCalculator.printAverage(monthlyJobFieldAverage, grossMonthlySalary);
        }
    }

}
