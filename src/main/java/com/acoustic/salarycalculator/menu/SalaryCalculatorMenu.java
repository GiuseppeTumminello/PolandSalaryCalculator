package com.acoustic.salarycalculator.menu;

import java.math.BigDecimal;

import com.acoustic.salarycalculator.inputvalidation.SalaryCalculatorInputValidation;
import com.acoustic.salarycalculator.jobscategories.JobsCategory;
import com.acoustic.salarycalculator.printer.SalaryCalculatorPrinter;
import com.acoustic.salarycalculator.service.JobTitleService;
import com.acoustic.salarycalculator.service.JobTitleServiceImpl;


public class SalaryCalculatorMenu {

    private final SalaryCalculatorInputValidation salaryCalculatorInputValidation;
    private final SalaryCalculatorPrinter printerCalculator;
    private final JobTitleService averageSalaryService;

    public SalaryCalculatorMenu() {
        this.salaryCalculatorInputValidation = new SalaryCalculatorInputValidation();
        this.printerCalculator = new SalaryCalculatorPrinter();
        this.averageSalaryService = new JobTitleServiceImpl();
    }


    public BigDecimal salaryCalculator() {
        BigDecimal grossMonthlySalary = salaryCalculatorInputValidation.userInput();
        printerCalculator.printSalaryCalculatorTax(grossMonthlySalary);
        return grossMonthlySalary;
    }

    public void statistics(BigDecimal grossMonthlySalary) {
        JobsCategory jobsCategory = salaryCalculatorInputValidation.surveyInput();
        if (jobsCategory != null) {
            printerCalculator.printJobTitle(jobsCategory);
            String jobTitle = salaryCalculatorInputValidation.jobTitleValidator(jobsCategory);
            averageSalaryService.save(grossMonthlySalary, jobTitle);
            BigDecimal monthlyJobTitleAverage = averageSalaryService.getAverageByJobTitle(jobTitle);
            printerCalculator.printAverage(monthlyJobTitleAverage, grossMonthlySalary);
        }
    }

}
