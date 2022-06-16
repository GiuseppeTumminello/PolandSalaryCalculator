package com.acoustic.salarycalculator.menulogic;

import java.math.BigDecimal;

import com.acoustic.salarycalculator.inputvalidation.SalaryCalculatorInputValidation;
import com.acoustic.salarycalculator.printer.SalaryCalculatorPrinter;
import com.acoustic.salarycalculator.service.JobTitleService;
import com.acoustic.salarycalculator.service.JobTitleServiceImpl;


public class SalaryCalculatorMenuLogic {

    private final SalaryCalculatorInputValidation salaryCalculatorInputValidation;
    private final SalaryCalculatorPrinter printerCalculator;
    private final JobTitleService averageSalaryService;

    public SalaryCalculatorMenuLogic() {
        this.salaryCalculatorInputValidation = new SalaryCalculatorInputValidation();
        this.printerCalculator = new SalaryCalculatorPrinter();
        this.averageSalaryService = new JobTitleServiceImpl();
    }


    public BigDecimal salaryCalculator() {
        BigDecimal grossMonthlySalary = salaryCalculatorInputValidation.userInput();
        printerCalculator.printSalaryCalculatorTax(grossMonthlySalary);
        return grossMonthlySalary;
    }

    public void survey(BigDecimal grossMonthlySalary) {
        int jobDepartmentId = salaryCalculatorInputValidation.surveyInput();
        if (jobDepartmentId != 0) {
            printerCalculator.printJobTitle(jobDepartmentId);
            String jobTitle = salaryCalculatorInputValidation.jobTitleValidator(jobDepartmentId);
            averageSalaryService.save(grossMonthlySalary, jobTitle);
            BigDecimal monthlyJobTitleAverage = averageSalaryService.getAverageByJobTitle(jobTitle);
            printerCalculator.printAverage(monthlyJobTitleAverage, grossMonthlySalary);
        }
    }

}
