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
    private final Connection connection;


    public JobTitleServiceImpl() {
        this.databaseConnection = new DatabaseConnection();
        this.connection = databaseConnection.getConnection();

    }

    @Override
    public int save(BigDecimal grossMonthlySalary) {
        PreparedStatement preparedStatement;
        try {

            String saveAllDataQuery = "INSERT INTO public.salary_calculator(" +
                    "pension_zus, disability_zus, sickness_zus, total_zus, health, gross_yearly, tax, net_monthly, " +
                    "net_yearly, gross_monthly) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
            preparedStatement = connection.prepareStatement(saveAllDataQuery);
            int count = 0;
            for (var value : SalaryCalculator.values()) {
                count++;
                preparedStatement.setBigDecimal(count, value.getOperator().apply(grossMonthlySalary));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Inserting data inside the database failed, please check your setup,  table name or columns name  if they are correct");
        }
        return 0;
    }


    @Override
    public BigDecimal getAverageByJobTile(String jobTitle) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select avg(gross_monthly) from salary_calculator where job_title= '" + jobTitle + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBigDecimal("avg");
            }
        } catch (SQLException e) {
            System.out.println("Retrieving data from the database failed, please check your setup,  table name or columns name  if they are correct");
        }
        return null;
    }

    @Override
    public void updateJobTitle(int id, String jobTitle) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE public.salary_calculator SET job_title=? where id=" + id);
            preparedStatement.setString(1, jobTitle);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Updating data to the database failed, please check your setup,  table name or columns name  if they are correct");
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
