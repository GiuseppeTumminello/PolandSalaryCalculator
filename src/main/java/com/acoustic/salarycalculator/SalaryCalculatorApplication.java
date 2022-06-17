package com.acoustic.salarycalculator;

import java.math.BigDecimal;

import com.acoustic.salarycalculator.menulogic.SalaryCalculatorMenuLogic;


public class SalaryCalculatorApplication {


    public static void main(String[] args) {
        SalaryCalculatorMenuLogic salaryCalculatorMenuLogic = new SalaryCalculatorMenuLogic();
        BigDecimal grossMonthlySalary = salaryCalculatorMenuLogic.salaryCalculator();
        salaryCalculatorMenuLogic.statistics(grossMonthlySalary);

    }

}
