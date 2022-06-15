package com.acoustic.salarycalculator.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.acoustic.salarycalculator.calculator.SalaryCalculator;
import com.acoustic.salarycalculator.dbconnection.DatabaseConnection;


public class JobTitleServiceImpl implements JobTitleService {

    private final DatabaseConnection databaseConnection;


    public JobTitleServiceImpl() {
        this.databaseConnection = new DatabaseConnection();

    }

    @Override
    public void save(BigDecimal grossMonthlySalary, String jobTitle) {
        PreparedStatement preparedStatement;
        try (Connection connection = databaseConnection.getConnection()) {

            String saveAllDataQuery = "INSERT INTO public.salary_calculator(" +
                    "pension_zus, disability_zus, sickness_zus, total_zus, health, gross_yearly, tax, net_monthly, " +
                    "net_yearly, gross_monthly, job_title) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(saveAllDataQuery);
            int count = 0;
            for (var value : SalaryCalculator.values()) {
                count++;
                preparedStatement.setBigDecimal(count, value.getOperator().apply(grossMonthlySalary));
            }
            preparedStatement.setString(11, jobTitle);
            preparedStatement.execute();

        } catch (SQLException exception) {
            System.out.println(
                    "Inserting data inside the database failed, please check your setup,  table name or columns name " +
                            " if they are correct");
        }

    }


    @Override
    public BigDecimal getAverageByJobTile(String jobTitle) {
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select avg(gross_monthly) from salary_calculator where job_title= '" + jobTitle + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBigDecimal("avg");
            }
        } catch (SQLException exception) {
            System.out.println(
                    "Retrieving data from the database failed, please check your setup,  table name or columns name  " +
                            "if they are correct");
        }
        return null;
    }

}
