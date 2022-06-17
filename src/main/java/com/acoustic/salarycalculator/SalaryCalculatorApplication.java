package com.acoustic.salarycalculator;

import java.math.BigDecimal;

import com.acoustic.salarycalculator.menu.SalaryCalculatorMenu;


public class SalaryCalculatorApplication {


    public static void main(String[] args) {
        SalaryCalculatorMenu salaryCalculatorMenu = new SalaryCalculatorMenu();
        BigDecimal grossMonthlySalary = salaryCalculatorMenu.salaryCalculator();
        salaryCalculatorMenu.statistics(grossMonthlySalary);

    }

}
