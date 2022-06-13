package org.example.enumApproch.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.enumApproch.enums.SalaryCalculatorEnum;
import org.example.enumApproch.dbConnection.DatabaseConnection;


public class JobTitleServiceImpl implements JobTitleService {

    private final DatabaseConnection hikariCPDataSource;
    private final Connection connection;


    public JobTitleServiceImpl() {
        this.hikariCPDataSource = new DatabaseConnection();
        this.connection = hikariCPDataSource.getConnection();

    }

    @Override
    public int save(BigDecimal grossSalary) {
        PreparedStatement preparedStatement;
        try {
            String saveAllDataQuery = "INSERT INTO public.salary_calculator(" +
                    "pension_zus, disability_zus, sickness_zus, total_zus, health, gross_yearly, tax, net_monthly, " +
                    "net_early, gross_monthly) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
            preparedStatement = connection.prepareStatement(saveAllDataQuery);
            int count = 0;
            for (var value : SalaryCalculatorEnum.values()) {
                count++;
                preparedStatement.setBigDecimal(count, value.getOperator().apply(grossSalary));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}
