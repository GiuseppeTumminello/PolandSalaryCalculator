package org.example.enumApproch;

import org.example.enumApproch.Service.AverageSalaryServiceImpl;
import org.example.enumApproch.menu.Menu;

import java.math.BigDecimal;

public class MainWithEnum {

    public static void main(String[] args) {
        Menu menu = new Menu();
        AverageSalaryServiceImpl averageSalaryService = new AverageSalaryServiceImpl();
        BigDecimal grossSalary = menu.userInput();
        averageSalaryService.save(grossSalary);
        extracted(grossSalary);
        menu.checkAverage(grossSalary);


    }

    private static void extracted(BigDecimal grossSalary) {
        for (var values : SalaryCalculatorEnum.values()) {
            System.out.print("\n" + values.getDescription());
            System.out.print(values.getOperator().apply(grossSalary));
        }
    }


}
