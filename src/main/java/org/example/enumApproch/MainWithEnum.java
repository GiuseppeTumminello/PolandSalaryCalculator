package org.example.enumApproch;

import org.example.enumApproch.service.JobTitleServiceImpl;
import org.example.enumApproch.menu.Menu;

import java.math.BigDecimal;

public class MainWithEnum {

    public static void main(String[] args) {


        Menu menu = new Menu();
        JobTitleServiceImpl averageSalaryService = new JobTitleServiceImpl();
        averageSalaryService.getAverageByJobTile(null);
        BigDecimal grossSalary = menu.userInput();
        int i = averageSalaryService.save(grossSalary);
        System.out.println(i);
        extracted(grossSalary);
        menu.checkAverage(grossSalary);
        averageSalaryService.getAverageByJobTile(null);
        averageSalaryService.updateJobTitle(i, "Software Engineer");





    }

    private static void extracted(BigDecimal grossSalary) {
        for (var values : SalaryCalculatorEnum.values()) {
            System.out.print("\n" + values.getDescription());
            System.out.print(values.getOperator().apply(grossSalary));
        }
    }


}
